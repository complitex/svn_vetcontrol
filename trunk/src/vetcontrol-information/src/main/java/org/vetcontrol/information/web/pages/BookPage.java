/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.information.web.pages;

import org.apache.wicket.MetaDataKey;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.vetcontrol.information.service.fasade.pages.BookPageFasade;
import org.vetcontrol.information.web.component.BookContentControl;
import org.vetcontrol.service.dao.ILocaleDAO;
import org.vetcontrol.web.template.FormTemplatePage;

import javax.ejb.EJB;
import java.beans.IntrospectionException;
import java.io.Serializable;
import java.util.Iterator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;

/**
 *
 * @author Artem
 */
public class BookPage extends FormTemplatePage {

    public class DataProvider extends SortableDataProvider<Serializable> implements IFilterStateLocator {

        private Serializable filterBean;
        private int size;

        public DataProvider() {
        }

        @Override
        public Iterator<Serializable> iterator(int first, int count) {
            return fasade.getContent(filterBean, first, count, getSort().getProperty(), getSort().isAscending(), BookPage.this.getLocale()).iterator();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public IModel model(Serializable object) {
            return new Model(object);
        }

        @Override
        public Object getFilterState() {
            return filterBean;
        }

        @Override
        public void setFilterState(Object state) {
            this.filterBean = (Serializable) state;
        }

        public void initSize() {
            Long localSize = fasade.size(filterBean);
            size = localSize == null ? 0 : localSize.intValue();
        }

        public void init(Class type, String sortProperty, boolean isAscending) throws InstantiationException, IllegalAccessException {
            filterBean = (Serializable) type.newInstance();
            setSort(sortProperty, isAscending);
        }
    }
    @EJB(name = "BookPageFasade")
    private BookPageFasade fasade;

    @EJB(name = "LocaleDAO")
    private ILocaleDAO localeDAO;
    
    public static final MetaDataKey SELECTED_BOOK_ENTRY = new MetaDataKey() {
    };
    
    static final String BOOK_TYPE = "bookType";
    private DataProvider dataProvider;

    public BookPage(PageParameters params) throws IntrospectionException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        init(params.getString(BOOK_TYPE));
    }

    public void init(String bookType) throws IntrospectionException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        final Class bookClass = Thread.currentThread().getContextClassLoader().loadClass(bookType);

        dataProvider = new DataProvider();
        dataProvider.init(bookClass, "id", true);
        dataProvider.initSize();

        Panel bookContent = new EmptyPanel("bookContent");
        WebMarkupContainer emptyContent = new WebMarkupContainer("emptyContent");

        if (dataProvider.size() != 0) {
            bookContent = new BookContentControl("bookContent", dataProvider,
                    bookClass,
                    fasade,
                    localeDAO.systemLocale()) {

                @Override
                public void selected(Serializable obj) {
                    goToEditPage(obj);
                }
            };
            emptyContent.setVisible(false);
        }
        add(bookContent);
        add(emptyContent);

        final Form form = new Form("form");
        add(form);

        form.add(new SubmitLink("new") {

            @Override
            public void onSubmit() {
                try {
                    final Serializable entry = (Serializable) bookClass.newInstance();
                    goToEditPage(entry);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void goToEditPage(Serializable entry) {
        getSession().setMetaData(SELECTED_BOOK_ENTRY, entry);
        setResponsePage(AddUpdateBookEntryPage.class);
    }
}
