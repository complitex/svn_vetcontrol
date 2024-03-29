package org.vetcontrol.user.web.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.entity.User;
import org.vetcontrol.entity.UserGroup;
import org.vetcontrol.service.UIPreferences;
import org.vetcontrol.service.UIPreferences.PreferenceType;
import org.vetcontrol.user.service.UserBean;
import org.vetcontrol.web.component.datatable.ArrowOrderByBorder;
import org.vetcontrol.web.component.paging.PagingNavigator;
import org.vetcontrol.web.component.toolbar.AddUserButton;
import org.vetcontrol.web.component.toolbar.ToolbarButton;
import org.vetcontrol.web.security.SecurityRoles;
import org.vetcontrol.web.template.TemplatePage;

import javax.ejb.EJB;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 * Date: 21.12.2009 21:23:07
 *
 * Класс используется для отображения списка пользователей с фильтрацией по ключевому слову и сортировкой.
 */
@AuthorizeInstantiation(SecurityRoles.USER_EDIT)
public class UserList extends TemplatePage {
    private static final Logger log = LoggerFactory.getLogger(UserList.class);

    @EJB(name = "UserBean")
    private UserBean userBean;

    private UIPreferences preferences;
    private static final String SORT_PROPERTY_KEY = UserList.class.getSimpleName() + "_SORT_PROPERTY";
    private static final String SORT_ORDER_KEY = UserList.class.getSimpleName() + "_SORT_ORDER";
    private static final String FILTER_KEY = UserList.class.getSimpleName() + "_FILTER";
    private static final String PAGE_NUMBER_KEY = UserList.class.getSimpleName() + "_PAGE_NUMBER";

    private DataView<User> userDataView;

    public UserList() {
        super();
        preferences = getPreferences();

        add(new Label("title", new ResourceModel("user.list.title")));

        add(new FeedbackPanel("messages"));

        //Форма фильтра по ключевому слову
        String filter = preferences.getPreference(PreferenceType.FILTER, FILTER_KEY, String.class);

        final Form<String> filterForm = new Form<String>("filter_form", new Model<String>(filter)) {

            @Override
            protected void onSubmit() {
                super.onSubmit();
            }
        };
        add(filterForm);
        filterForm.add(new TextField<String>("filter_value", filterForm.getModel()));

        //Модель данных для сортировки и постраничного отображения списка пользователей
        final SortableDataProvider<User> userSort = new SortableDataProvider<User>() {

            @Override
            public Iterator<? extends User> iterator(int first, int count) {
                SortParam sortParam = getSort();
                preferences.putPreference(PreferenceType.SORT_PROPERTY, SORT_PROPERTY_KEY, sortParam.getProperty());
                preferences.putPreference(PreferenceType.SORT_ORDER, SORT_ORDER_KEY, sortParam.isAscending());

                UserBean.OrderBy order = UserBean.OrderBy.valueOf(sortParam.getProperty());

                String filter = filterForm.getModelObject();
                preferences.putPreference(UIPreferences.PreferenceType.FILTER, FILTER_KEY, filter);

                try {
                    return userBean.getUsers(first, count, order, sortParam.isAscending(), filter, getSession().getLocale()).iterator();
                } catch (Exception e) {
                    error("Ошибка получения списка пользователей из базы данных");
                    log.error("Ошибка получения списка пользователей из базы данных", e);
                }
                return null;
            }

            @Override
            public int size() {
                try {
                    return userBean.getUserCount(filterForm.getModelObject()).intValue();
                } catch (Exception e) {
                    error("Ошибка получения количества списка пользователей из базы данных");
                    log.error("Ошибка получения количества списка пользователей из базы данных", e);
                }
                return 0;
            }

            @Override
            public IModel<User> model(User object) {
                return new Model<User>(object);
            }
        };

        //sort property and ordering
        String sortPropertyFromPreferences = preferences.getPreference(PreferenceType.SORT_PROPERTY, SORT_PROPERTY_KEY, String.class);
        Boolean sortOrderFromPreferences = preferences.getPreference(PreferenceType.SORT_ORDER, SORT_ORDER_KEY, Boolean.class);
        String sortProp = sortPropertyFromPreferences != null ? sortPropertyFromPreferences : "LAST_NAME";
        boolean asc = sortOrderFromPreferences != null ? sortOrderFromPreferences : true;
        userSort.setSort(sortProp, asc);

        //Таблица пользователей
        userDataView = new DataView<User>("users", userSort, 1) {

            @Override
            protected void populateItem(Item<User> userItem) {
                User user = userItem.getModelObject();
                userItem.add(new Label("last_name", user.getLastName()));
                userItem.add(new Label("first_name", user.getFirstName()));
                userItem.add(new Label("middle_name", user.getMiddleName()));
                if (user.getJob() != null){
                    userItem.add(new Label("job", user.getJob().getDisplayName(getLocale(), getSystemLocale())));
                }else{
                    userItem.add(new Label("job",""));                                        
                }
                userItem.add(new Label("department", user.getDepartment().getDisplayName(getLocale(), getSystemLocale())));
                userItem.add(new Label("passingBorderPoint", user.getPassingBorderPoint() != null ? user.getPassingBorderPoint().getName() : ""));
                Link<UserEdit> edit = new BookmarkablePageLink<UserEdit>("edit", UserEdit.class,
                        new PageParameters("user_id=" + user.getId()));
                edit.add(new Label("login", user.getLogin()));
                userItem.add(edit);
                userItem.add(new Label("groups", getGroups(user)));
            }
        };

        //Ссылки для активации сортировки по полям
        add(new ArrowOrderByBorder("order_last_name", UserBean.OrderBy.LAST_NAME.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });
        add(new ArrowOrderByBorder("order_first_name", UserBean.OrderBy.FIRST_NAME.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });
        add(new ArrowOrderByBorder("order_middle_name", UserBean.OrderBy.MIDDLE_NAME.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });
        add(new ArrowOrderByBorder("order_job", UserBean.OrderBy.JOB.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });
        add(new ArrowOrderByBorder("order_department", UserBean.OrderBy.DEPARTMENT.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });
        add(new ArrowOrderByBorder("order_passing_border_point", UserBean.OrderBy.PASSING_BORDER_POINT.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });
        add(new ArrowOrderByBorder("order_login", UserBean.OrderBy.LOGIN.name(), userSort) {

            protected void onSortChanged() {
                userDataView.setCurrentPage(0);
            }
        });

        add(new PagingNavigator("navigator", userDataView, "itemsPerPage", preferences, PAGE_NUMBER_KEY));
        add(userDataView);
    }

    /**
     * Генерирует строку списка групп пользователей для отображения
     * @param user Пользователь
     * @return Список групп
     */
    private String getGroups(User user) {
        if (user.getUserGroups() == null || user.getUserGroups().isEmpty()) {
            return getString("user.blocked");
        }

        StringBuilder sb = new StringBuilder();

        for (Iterator<UserGroup> it = user.getUserGroups().iterator();;) {
            sb.append(getString(it.next().getSecurityGroup().name()));
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append(", ");
        }
    }

    @Override
    protected List<ToolbarButton> getToolbarButtons(String id) {
        return Arrays.asList((ToolbarButton) new AddUserButton(id) {

            @Override
            protected void onClick() {
                setResponsePage(UserEdit.class);
            }
        });
    }
}
