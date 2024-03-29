package org.vetcontrol.document.web.pages;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.PageParameters;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.*;
import org.vetcontrol.book.ShowBooksMode;
import org.vetcontrol.document.service.AvailableMovementTypes;
import org.vetcontrol.document.service.CommonDocumentBean;
import org.vetcontrol.document.service.DocumentCargoBean;
import org.vetcontrol.document.service.DocumentCargoFilter;
import org.vetcontrol.entity.*;
import org.vetcontrol.service.ClientBean;
import org.vetcontrol.service.UIPreferences;
import org.vetcontrol.service.UserProfileBean;
import org.vetcontrol.web.component.BookmarkablePageLinkPanel;
import org.vetcontrol.web.component.DatePicker;
import org.vetcontrol.web.component.MovementTypeChoicePanel;
import org.vetcontrol.web.component.VehicleTypeChoicePanel;
import org.vetcontrol.web.component.book.BookChoiceRenderer;
import org.vetcontrol.web.component.datatable.ArrowOrderByBorder;
import org.vetcontrol.web.component.paging.PagingNavigator;
import org.vetcontrol.web.component.toolbar.AddDocumentButton;
import org.vetcontrol.web.component.toolbar.ToolbarButton;
import org.vetcontrol.web.template.ListTemplatePage;

import javax.ejb.EJB;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.vetcontrol.document.service.DocumentCargoBean.OrderBy;
import static org.vetcontrol.web.security.SecurityRoles.*;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 12.01.2010 12:54:13
 */
@AuthorizeInstantiation({DOCUMENT_CREATE, DOCUMENT_DEP_VIEW, DOCUMENT_DEP_CHILD_VIEW})
public class DocumentCargoList extends ListTemplatePage {

    private static final String PAGE_NUMBER_KEY = DocumentCargoList.class.getSimpleName() + "_PAGE_NUMBER";
    private static final String SORT_PROPERTY_KEY = DocumentCargoList.class.getSimpleName() + "_SORT_PROPERTY";
    private static final String SORT_ORDER_KEY = DocumentCargoList.class.getSimpleName() + "_SORT_ORDER";
    private static final String FILTER_KEY = DocumentCargoList.class.getSimpleName() + "_FILTER";
    @EJB(name = "CommonDocumentBean")
    private CommonDocumentBean commonDocumentBean;
    @EJB(name = "DocumentCargoBean")
    private DocumentCargoBean documentCargoBean;
    @EJB(name = "UserProfileBean")
    private UserProfileBean userProfileBean;
    @EJB(name = "ClientBean")
    private ClientBean clientBean;

    public DocumentCargoList() {
        super();

        final boolean server = clientBean.isServer();

        add(new Label("title", new ResourceModel("document.cargo.list.title")));
        add(new Label("header", new ResourceModel("document.cargo.list.title")));

        add(new FeedbackPanel("messages"));

        final UIPreferences preferences = getPreferences();

        //Фильтр
        DocumentCargoFilter filterObject = preferences.getPreference(UIPreferences.PreferenceType.FILTER,
                FILTER_KEY, DocumentCargoFilter.class);
        if (filterObject == null) {
            filterObject = newDocumentCargoFilter();
        }

        final IModel<DocumentCargoFilter> filter = new CompoundPropertyModel<DocumentCargoFilter>(filterObject);
        final Form<DocumentCargoFilter> filterForm = new Form<DocumentCargoFilter>("filter_form", filter);

        Link filter_reset = new Link("filter_reset") {

            @Override
            public void onClick() {
                filterForm.clearInput();
                filter.setObject(newDocumentCargoFilter());
            }
        };
        filterForm.add(filter_reset);

        filterForm.add(new TextField<String>("id"));

        filterForm.add(new MovementTypeChoicePanel("movementType", new PropertyModel<MovementType>(filter, "movementType"),
                AvailableMovementTypes.get(DocumentCargo.class), false, null));
        filterForm.add(new VehicleTypeChoicePanel("vehicleType", new PropertyModel<VehicleType>(filter, "vehicleType"), false, null));
        filterForm.add(new TextField<String>("receiverName"));
        filterForm.add(new TextField<String>("receiverAddress"));
        filterForm.add(new TextField<String>("senderName"));

        filterForm.add(new DropDownChoice<CountryBook>("senderCountry", commonDocumentBean.getBookList(CountryBook.class, ShowBooksMode.ALL),
                new BookChoiceRenderer<CountryBook>(getSystemLocale())));
        DatePicker<Date> created = new DatePicker<Date>("created");
        filterForm.add(created);

        DropDownChoice<Synchronized.SyncStatus> ddcSyncStatus =
                new DropDownChoice<Synchronized.SyncStatus>("syncStatus", Arrays.asList(Synchronized.SyncStatus.values()),
                new IChoiceRenderer<Synchronized.SyncStatus>() {

                    @Override
                    public Object getDisplayValue(Synchronized.SyncStatus object) {
                        return getString(object.name());
                    }

                    @Override
                    public String getIdValue(Synchronized.SyncStatus object, int index) {
                        return object.name();
                    }
                });
        ddcSyncStatus.setVisible(!server);
        filterForm.add(ddcSyncStatus);

        //Модель данных списка карточек на груз
        final SortableDataProvider<DocumentCargo> dataProvider = new SortableDataProvider<DocumentCargo>() {

            @Override
            public Iterator<? extends DocumentCargo> iterator(int first, int count) {
                DocumentCargoBean.OrderBy sort = OrderBy.valueOf(getSort().getProperty());
                boolean asc = getSort().isAscending();

                preferences.putPreference(UIPreferences.PreferenceType.SORT_PROPERTY, SORT_PROPERTY_KEY, getSort().getProperty());
                preferences.putPreference(UIPreferences.PreferenceType.SORT_ORDER, SORT_ORDER_KEY, asc);
                preferences.putPreference(UIPreferences.PreferenceType.FILTER, FILTER_KEY, filter.getObject());

                return documentCargoBean.getDocumentCargos(filter.getObject(), first, count, sort, asc).iterator();
            }

            @Override
            public int size() {
                return documentCargoBean.getDocumentCargosSize(filter.getObject()).intValue();
            }

            @Override
            public IModel<DocumentCargo> model(DocumentCargo object) {
                return new Model<DocumentCargo>(object);
            }
        };
        String sortPropertyFromPreferences = preferences.getPreference(UIPreferences.PreferenceType.SORT_PROPERTY, SORT_PROPERTY_KEY, String.class);
        Boolean sortOrderFromPreferences = preferences.getPreference(UIPreferences.PreferenceType.SORT_ORDER, SORT_ORDER_KEY, Boolean.class);
        String sortProp = sortPropertyFromPreferences != null ? sortPropertyFromPreferences : OrderBy.CREATED.name();
        boolean asc = sortOrderFromPreferences != null ? sortOrderFromPreferences : false;
        dataProvider.setSort(sortProp, asc);

        //Таблица документов
        final DataView<DocumentCargo> dataView = new DataView<DocumentCargo>("documents", dataProvider, 1) {

            @Override
            protected void populateItem(Item<DocumentCargo> item) {
                DocumentCargo dc = item.getModelObject();

                PageParameters pageParameters = new PageParameters("document_cargo_id=" + dc.getId() + ","
                        + "client_id=" + dc.getClient().getId() + "," + "department_id=" + dc.getDepartment().getId());

                item.add(new BookmarkablePageLinkPanel<DocumentCargo>("id", dc.getDisplayId(),
                        DocumentCargoView.class, pageParameters));
                item.add(new Label("movementType", MovementTypeChoicePanel.getDisplayName(dc.getMovementType(), getLocale())));
                item.add(new Label("vehicleType", VehicleTypeChoicePanel.getDisplayName(dc.getVehicleType(), getLocale())));
                item.add(new Label("receiverName", dc.getReceiverName()));
                item.add(new Label("receiverAddress", dc.getReceiverAddress()));
                item.add(new Label("senderName", dc.getSenderName()));
                item.add(new Label("senderCountry", dc.getSenderCountry().getDisplayName(getLocale(), getSystemLocale())));
                item.add(new DateLabel("created", new Model<Date>(dc.getCreated()), new StyleDateConverter(true)));

                Label syncStatus = new Label("syncStatus", getString(dc.getSyncStatus().name()));
                syncStatus.setVisible(!server);
                item.add(syncStatus);
                if ((server || !dc.getSyncStatus().equals(Synchronized.SyncStatus.SYNCHRONIZED)) && canEdit(dc)) {
                    item.add(new BookmarkablePageLinkPanel<DocumentCargo>("action", getString("document.cargo.list.edit"),
                            "edit:"+item.getId(), DocumentCargoEdit.class, pageParameters));
                } else {
                    item.add(new BookmarkablePageLinkPanel<DocumentCargo>("action", getString("document.cargo.list.view"),
                            DocumentCargoView.class, pageParameters));
                }
            }
        };

        //Ссылки для сортировки
        addOrderByBorder(filterForm, "order_id", OrderBy.ID.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_movementType", OrderBy.MOVEMENT_TYPE.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_vehicleType", OrderBy.VEHICLE_TYPE.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_receiver_name", OrderBy.RECEIVER_NAME.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_receiver_address", OrderBy.RECEIVER_ADDRESS.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_sender_name", OrderBy.SENDER_NAME.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_sender_country", OrderBy.SENDER_COUNTRY.name(), dataProvider, dataView);
        addOrderByBorder(filterForm, "order_created", OrderBy.CREATED.name(), dataProvider, dataView);

        ArrowOrderByBorder orderSyncStatus = new ArrowOrderByBorder("order_syncStatus", OrderBy.SYNC_STATUS.name(), dataProvider) {

            @Override
            protected void onSortChanged() {
                dataView.setCurrentPage(0);
            }
        };
        orderSyncStatus.setVisible(!server);
        filterForm.add(orderSyncStatus);

        //Панель ссылок для постраничной навигации        
        filterForm.add(new PagingNavigator("navigator", dataView, "itemsPerPage", getPreferences(), PAGE_NUMBER_KEY));

        filterForm.add(dataView);
        add(filterForm);
    }

    private void addOrderByBorder(MarkupContainer container, String id, String property, ISortStateLocator stateLocator, final DataView dateView) {
        container.add(new ArrowOrderByBorder(id, property, stateLocator) {

            @Override
            protected void onSortChanged() {
                dateView.setCurrentPage(0);
            }
        });
    }

    private DocumentCargoFilter newDocumentCargoFilter() {
        DocumentCargoFilter filter = new DocumentCargoFilter(getLocale(), getSystemLocale());

        if (hasAnyRole(DOCUMENT_DEP_VIEW)) {
            filter.setDepartment(userProfileBean.getCurrentUser().getDepartment());
            filter.setChildDepartments(hasAnyRole(DOCUMENT_DEP_CHILD_VIEW));
            return filter;
        }

        if (hasAnyRole(DOCUMENT_CREATE)) {
            filter.setCreator(userProfileBean.getCurrentUser());
            return filter;
        }

        return filter;
    }

    private boolean canEdit(DocumentCargo dc) {
        User currentUser = userProfileBean.getCurrentUser();

        boolean authorized = hasAnyRole(DOCUMENT_EDIT)
                && currentUser.getId().equals(dc.getCreator().getId());

        if (!authorized && hasAnyRole(DOCUMENT_DEP_EDIT)) {
            authorized = currentUser.getDepartment().getId().equals(dc.getCreator().getDepartment().getId());
        }

        if (!authorized && hasAnyRole(DOCUMENT_DEP_CHILD_EDIT)) {
            for (Department d = dc.getCreator().getDepartment(); d != null; d = d.getParent()) {
                if (d.getId().equals(currentUser.getDepartment().getId())) {
                    authorized = true;
                    break;
                }
            }
        }
        return authorized;
    }

    @Override
    protected List<ToolbarButton> getToolbarButtons(String id) {
        if (hasAnyRole(DOCUMENT_CREATE)) {
            return Arrays.asList((ToolbarButton) new AddDocumentButton(id) {

                @Override
                protected void onClick() {
                    setResponsePage(DocumentCargoEdit.class);
                }
            });
        }

        return null;
    }
}
