package org.vetcontrol.web.component;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AbstractAutoCompleteTextRenderer;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteSettings;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.entity.CargoMode;
import org.vetcontrol.entity.CargoType;
import org.vetcontrol.service.CargoTypeBean;
import org.vetcontrol.service.dao.ILocaleDAO;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 23.01.2010 23:05:55
 */
public class UKTZEDField extends Panel {
    private static final Logger log = LoggerFactory.getLogger(UKTZEDField.class);

    private final static int MAX_ITEM = 10;

    @EJB(name = "LocaleDAO")
    private ILocaleDAO localeDAO;

    @EJB(name = "CargoTypeBean")
    private CargoTypeBean cargoTypeBean;

    final AutoCompleteTextField<String> uktzed, name;

    private IModel<CargoType> model;

    public interface IUKTZEDFieldListener extends Serializable{
        public void update(CargoType cargoType);
    }

    private IUKTZEDFieldListener listener;

    public UKTZEDField(String id, final IModel<CargoType> model, final IModel<CargoMode> cargoModeModel, final Component... ajaxUpdate) {
        super(id, model);

        this.model = model;

        final Locale system = localeDAO.systemLocale();

        AutoCompleteSettings settings = new AutoCompleteSettings();
        settings.setAdjustInputWidth(false);

        AbstractAutoCompleteTextRenderer<String> renderer = new AbstractAutoCompleteTextRenderer<String>(){

            @Override
            protected String getTextValue(String s) {
                return s;
            }

            @Override
            protected CharSequence getOnSelectJavascriptExpression(String item) {

                return  "input.replace('\\t', '                                                                 \\t');";
            }
        };

        uktzed = new AutoCompleteTextField<String>("uktzed",
                new Model<String>(model.getObject() != null ? model.getObject().getCode() : ""),
                String.class,
                renderer,
                settings){

            @Override
            protected Iterator<String> getChoices(String input) {
                List<CargoType> cargoTypes = cargoTypeBean.getCargoTypesByCode(cargoModeModel != null ? cargoModeModel.getObject() : null, input, MAX_ITEM);
                List<String> choices = new ArrayList<String>();
                for (CargoType ct : cargoTypes){
                    choices.add(ct.getCode() + "\t" + ct.getDisplayName(getLocale(), system));
                }

                return choices.iterator();
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);

                String s = getModelValue();

                if (s !=null && !s.isEmpty() && !cargoTypeBean.hasCargoType(s)){
                    tag.getAttributes().put("class", "error");
                }
            }
        };

        uktzed.setOutputMarkupId(true);
        add(uktzed);

        name = new AutoCompleteTextField<String>("name",
                new Model<String>(model.getObject() != null ? model.getObject().getDisplayName(getLocale(), system) : ""),
                String.class,
                renderer,
                settings){

            @Override
            protected Iterator<String> getChoices(String input) {
                List<CargoType> cargoTypes = cargoTypeBean.getCargoTypesByName(cargoModeModel != null ? cargoModeModel.getObject() : null, input, MAX_ITEM);
                List<String> choices = new ArrayList<String>();
                for (CargoType ct : cargoTypes){
                    String s = ct.getDisplayName(getLocale(), system);

                    if (s != null){
                        if (s.length() > 120){
                            s = s.substring(0,120) + "...";
                        }
                        s = s.replaceAll("\t"," ");
                    }
                    choices.add(s + " | \t" + ct.getCode());
                }

                return choices.iterator();
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("title", getModelValue());
            }
        };
        name.setOutputMarkupId(true);
        add(name);

        uktzed.add(new AjaxFormComponentUpdatingBehavior("onchange"){

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                String input = uktzed.getModelObject();

                if (input == null) return;

                String code = input.indexOf('\t') > -1 ?  input.substring(0, input.indexOf('\t')).trim() : input;

                CargoType cargoType = cargoTypeBean.getCargoType(code);
                model.setObject(cargoType);

                name.setModelObject(cargoType != null ? cargoType.getDisplayName(getLocale(), system) : "");

                if (cargoType != null){
                    uktzed.setModelObject(code);
                }

                target.addComponent(name);
                target.addComponent(uktzed);                

                for (Component component : ajaxUpdate){
                    target.addComponent(component);
                }

                if (listener != null){
                    listener.update(cargoType);
                }
            }
        });

        name.add(new AjaxFormComponentUpdatingBehavior("onchange"){

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                String input = name.getModelObject();

                if (input == null) return;

                if (input.indexOf('\t') > -1){
                    String code = input.substring(input.indexOf('\t')).trim();

                    CargoType cargoType = cargoTypeBean.getCargoType(code);
                    model.setObject(cargoType);

                    if (cargoType != null){
                        uktzed.setModelObject(code);
                        name.setModelObject(cargoType.getDisplayName(getLocale(), system));
                        target.addComponent(uktzed);
                        target.addComponent(name);
                    }else{
                        cargoType = cargoTypeBean.getCargoType(uktzed.getModelObject());
                        name.setModelObject(cargoType != null ? cargoType.getDisplayName(getLocale(), system) : "");
                        target.addComponent(name);
                    }

                    for (Component component : ajaxUpdate){
                        target.addComponent(component);
                    }

                    if (listener != null){
                        listener.update(cargoType);
                    }
                }else{
                    String code = uktzed.getModelObject();
                    if (code != null){
                        uktzed.setModelObject(code.trim());
                        target.addComponent(uktzed);
                    }
                }
            }
        });
    }

    public void clear(){
        name.setModelObject("");
        uktzed.setModelObject("");
    }

    public IModel<CargoType> getModel() {
        return model;
    }

    public IUKTZEDFieldListener getListener() {
        return listener;
    }

    public void setListener(IUKTZEDFieldListener listener) {
        this.listener = listener;
    }
}
