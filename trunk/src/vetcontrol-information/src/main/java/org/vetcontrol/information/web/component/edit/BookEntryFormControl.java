/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.information.web.component.edit;

import java.beans.IntrospectionException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.util.book.BeanPropertyUtil;
import org.vetcontrol.util.book.Property;
import org.vetcontrol.information.web.model.DisplayPropertyLocalizableModel;
import org.vetcontrol.service.dao.IBookViewDAO;

/**
 *
 * @author Artem
 */
public abstract class BookEntryFormControl extends FormComponentPanel {

    private static final Logger log = LoggerFactory.getLogger(BookEntryFormControl.class);

    @EJB(name = "BookViewDAO")
    private IBookViewDAO bookViewDAO;

    public BookEntryFormControl(String id, final IModel model, final Locale systemLocale) throws IntrospectionException {
        super(id, model);

        List<Property> filtered = BeanPropertyUtil.getProperties(model.getObject().getClass());

        ListView<Property> fields = new ListView<Property>("bookFields", filtered) {

            @Override
            protected void populateItem(ListItem<Property> item) {
                Property prop = item.getModelObject();

                item.add(new Label("bookFieldDesc", new DisplayPropertyLocalizableModel(prop, BookEntryFormControl.this)));

                WebMarkupContainer requiredContainer = new WebMarkupContainer("bookFieldRequired");
                requiredContainer.setVisible(!prop.isNullable());
                item.add(requiredContainer);

                boolean isSimpleText = false;
                boolean isDate = false;
                boolean isLocalizableText = false;
                boolean isSelectable = false;
                boolean isAutoComplete = false;
                boolean isBoolean = false;

                if (prop.getType().equals(String.class) || prop.getType().equals(int.class) || prop.getType().equals(Integer.class)
                        || prop.getType().equals(long.class) || prop.getType().equals(Long.class)) {
                    isSimpleText = true;
                } else if (Date.class.isAssignableFrom(prop.getType())) {
                    isDate = true;
                } else if (prop.isLocalizable()) {
                    isLocalizableText = true;
                } else if (prop.isBookReference()) {
                    switch (prop.getUiType()) {
                        case SELECT:
                            isSelectable = true;
                            break;
                        case AUTO_COMPLETE:
                            isAutoComplete = true;
                            break;
                    }
                } else if (prop.getType().equals(boolean.class) || prop.getType().equals(Boolean.class)) {
                    isBoolean = true;
                }

                IModel m = new PropertyModel(model, prop.getName());

                Panel datePanel = new EmptyPanel("datePanel");
                Panel textPanel = new EmptyPanel("textPanel");
                Panel localizableTextPanel = new EmptyPanel("localizableTextPanel");
                Panel selectablePanel = new EmptyPanel("selectablePanel");
                Panel autoCompleteSelectPanel = new EmptyPanel("autoCompleteSelectPanel");
                Panel booleanPanel = new EmptyPanel("booleanPanel");

                //choose what panel is editable:
                if (isSimpleText) {
                    textPanel = new TextPanel("textPanel", m, prop);
                } else if (isLocalizableText) {
                    localizableTextPanel = new LocalizableTextPanel("localizableTextPanel", m, prop, systemLocale);
                } else if (isDate) {
                    datePanel = new DatePanel("datePanel", m, prop);
                } else if (isSelectable) {
                    selectablePanel = new SelectPanel("selectablePanel", m, prop, bookViewDAO.getContent(prop.getType()), systemLocale);
                } else if (isAutoComplete) {
                    autoCompleteSelectPanel = new AutoCompleteSelectPanel("autoCompleteSelectPanel", m, prop);
                } else if (isBoolean) {
                    booleanPanel = new BooleanPanel("booleanPanel", m, prop);
                }

                item.add(datePanel);
                item.add(textPanel);
                item.add(localizableTextPanel);
                item.add(selectablePanel);
                item.add(autoCompleteSelectPanel);
                item.add(booleanPanel);
            }
        };
        fields.setReuseItems(true);
        add(fields);

        add(
                new SubmitLink("saveOrUpdateBook") {

                    @Override
                    public void onSubmit() {
                        saveOrUpdate();
                    }
                });

        add(
                new SubmitLink("cancel") {

                    @Override
                    public void onSubmit() {
                        cancel();
                    }
                }.setDefaultFormProcessing(
                false));
    }

    public abstract void saveOrUpdate();

    public abstract void cancel();
}