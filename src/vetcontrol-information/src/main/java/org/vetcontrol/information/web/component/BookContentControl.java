/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.information.web.component;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.wicket.authorization.strategies.role.IRoleCheckingStrategy;
import org.apache.wicket.authorization.strategies.role.Roles;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.GoAndClearFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.vetcontrol.service.UIPreferences;
import org.vetcontrol.information.service.fasade.pages.BookPageFasade;
import org.vetcontrol.util.book.BeanPropertyUtil;
import org.vetcontrol.information.util.web.Constants;
import org.vetcontrol.util.book.Property;
import org.vetcontrol.information.web.model.DisplayBookClassModel;
import org.vetcontrol.information.web.model.DisplayPropertyLocalizableModel;
import org.vetcontrol.information.web.pages.BookPage;
import org.vetcontrol.information.web.pages.BookPage.DataProvider;
import org.vetcontrol.web.component.paging.PagingNavigator;
import org.vetcontrol.web.security.SecurityRoles;

/**
 *
 * @author Artem
 */
public abstract class BookContentControl extends Panel {

    private class EditPanel extends Panel {

        public EditPanel(String id, final IModel<Serializable> model) {
            super(id, model);

            add(new Link("edit") {

                @Override
                public void onClick() {
                    selected(model.getObject());
                }
            });
        }
    }
    private Panel navigator;

    public BookContentControl(String id, final DataProvider dataProvider, final Class bookClass, BookPageFasade fasade,
            Locale systemLocale, final UIPreferences preferences) throws IntrospectionException {
        super(id);

        add(new Label("bookName", new DisplayBookClassModel(bookClass, getLocale())));

        List<IColumn<Serializable>> columns = new ArrayList<IColumn<Serializable>>();

        for (Property prop : BeanPropertyUtil.getProperties(bookClass)) {
            columns.add(new BookPropertyColumn<Serializable>(this, new DisplayPropertyLocalizableModel(prop, this), prop, fasade, systemLocale));
        }
        IRoleCheckingStrategy application = (IRoleCheckingStrategy) getApplication();
        if (application.hasAnyRole(new Roles(SecurityRoles.INFORMATION_EDIT))) {
            columns.add(new AbstractColumn(new ResourceModel("book.edit.header")) {

                @Override
                public void populateItem(Item cellItem, String componentId, IModel rowModel) {
                    cellItem.add(new EditPanel(componentId, rowModel));
                }
            });
        }
        final DataTable table = new DataTable("table", columns.toArray(new IColumn[columns.size()]), dataProvider, Constants.ROWS_PER_PAGE) {

            @Override
            protected void onPageChanged() {
                preferences.putPreference(UIPreferences.PreferenceType.PAGE_NUMBER, bookClass.getSimpleName() + BookPage.PAGE_NUMBER_KEY_SUFFIX, getCurrentPage());
            }
        };
        //retrieve table page from preferences.
        Integer page = preferences.getPreference(UIPreferences.PreferenceType.PAGE_NUMBER, bookClass.getSimpleName() + BookPage.PAGE_NUMBER_KEY_SUFFIX,
                Integer.class);
        if (page != null) {
            table.setCurrentPage(page);
        }

        table.addTopToolbar(new HeadersToolbar(table, dataProvider));

        initNavigator(table);

        final FilterForm filterForm = new FilterForm("filterForm", dataProvider) {

            @Override
            protected void onSubmit() {
                dataProvider.initSize();
                super.onSubmit();
                changeNavigator();
            }

            private void changeNavigator() {
                Panel newNavigator = null;
                if (table.getPageCount() > 1) {
                    newNavigator = new PagingNavigator("navigator", table);
                } else {
                    newNavigator = new EmptyPanel("navigator");
                }
                navigator.replaceWith(newNavigator);
                navigator = newNavigator;
            }
        };

        GoAndClearFilter goAndClearFilter = new GoAndClearFilter("goAndClearFilter", filterForm, new ResourceModel("book.filter.button.go"),
                new ResourceModel("book.filter.button.clear")) {

            @Override
            protected void onGoSubmit(Button button) {
                //save filter bean in preferences.
                Object filterBean = button.getForm().getModelObject();
                preferences.putPreference(UIPreferences.PreferenceType.FILTER, filterBean.getClass().getSimpleName() + BookPage.FILTER_KEY_SUFFIX,
                        filterBean);
            }

            @Override
            protected void onClearSubmit(Button button) {
                try {
                    Object filterBean = bookClass.newInstance();
                    button.getForm().setDefaultModelObject(filterBean);
                    preferences.putPreference(UIPreferences.PreferenceType.FILTER, filterBean.getClass().getSimpleName() + BookPage.FILTER_KEY_SUFFIX,
                            filterBean);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        filterForm.add(goAndClearFilter);
        table.addTopToolbar(new FilterToolbar(table, filterForm, dataProvider));
        table.setOutputMarkupId(true);

        filterForm.add(navigator);
        filterForm.add(table);
        add(filterForm);
    }

    private void initNavigator(final DataTable table) {
        navigator = new EmptyPanel("navigator");
        if (table.getPageCount() > 1) {
            navigator = new PagingNavigator("navigator", table);
        }
    }

    public abstract void selected(Serializable obj);
}
