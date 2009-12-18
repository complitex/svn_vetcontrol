/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.web.components;

import java.util.List;
import java.util.Locale;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Artem
 */
public class LocalePicker extends Panel {

    public LocalePicker(String id, final List<Locale> supportedLocales) {
        super(id);

        if (getSession().getLocale() == null || !supportedLocales.contains(getSession().getLocale())) {
            getSession().setLocale(supportedLocales.get(0));
        }
        add(new DropDownChoice("localeDropDown", new IModel<Locale>() {

            public Locale getObject() {
                return getSession().getLocale();
            }

            public void setObject(Locale locale) {
                getSession().setLocale(locale);
            }

            public void detach() {
            }
        }, supportedLocales, new ChoiceRenderer<Locale>() {

            @Override
            public Object getDisplayValue(Locale locale) {
                return locale.getDisplayName(getLocale());
            }
        }) {

            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        });
    }
}