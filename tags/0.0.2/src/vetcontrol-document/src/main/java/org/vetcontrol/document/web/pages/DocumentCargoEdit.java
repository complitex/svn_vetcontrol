package org.vetcontrol.document.web.pages;

import org.apache.wicket.Component;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.odlabs.wiquery.ui.datepicker.DatePicker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.document.service.DocumentBean;
import org.vetcontrol.entity.*;
import org.vetcontrol.service.dao.IBookViewDAO;
import org.vetcontrol.service.dao.ILocaleDAO;
import org.vetcontrol.util.book.BeanPropertyUtil;
import org.vetcontrol.web.security.SecurityRoles;
import org.vetcontrol.web.template.FormTemplatePage;

import javax.ejb.EJB;
import java.util.Date;
import java.util.List;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 12.01.2010 15:44:20
 */
@AuthorizeInstantiation({SecurityRoles.DOCUMENT_CREATE, SecurityRoles.DOCUMENT_EDIT})
public class DocumentCargoEdit extends FormTemplatePage{
    private static final Logger log = LoggerFactory.getLogger(DocumentCargoEdit.class);

    @EJB(name = "DocumentBean")
    DocumentBean documentBean;

    @EJB(name = "LocaleDAO")
    private ILocaleDAO localeDAO;

    @EJB(name = "BookViewDAO")
    private IBookViewDAO bookViewDAO;
    
    public DocumentCargoEdit() {
        super();
        init(null);
    }

    public DocumentCargoEdit(final PageParameters parameters){
        super();
        init(parameters.getAsLong("doc_cargo_id"));        
    }

    private void init(final Long id){
        add(new Label("title", getString("document.cargo.edit.title")));

        add(new FeedbackPanel("messages"));

        //Модель данных
        DocumentCargo documentCargo = null;
        try {
            documentCargo = (id != null) ? documentBean.loadDocumentCargo(id) : new DocumentCargo();
        } catch (Exception e) {
            log.error("Карточка на груз по id = " + id + " не найдена", e);
        }

        final Model<DocumentCargo> documentCargoModel = new Model<DocumentCargo>(documentCargo);

        //Форма
        final Form form = new Form<DocumentCargo>("doc_cargo_edit_form", documentCargoModel){
            @Override
            protected void onSubmit() {
                try {
                    documentBean.save(getModelObject());
                    info("Карточка на груз №" + getModelObject().getId() + " сохранена");
                } catch (Exception e) {
                    error("Ошибка сохранения карточки на груз №" + getModelObject().getId());
                    log.error("Ошибка сохранения карточки на груз №" + getModelObject().getId(), e);
                }
            }
        };
        add(form);

        //Тип движения груза
        addDropDownChoice(form, "document.cargo.movement_type", MovementType.class, documentCargoModel, "movementType");

        //Тип транспортного средства
        addDropDownChoice(form, "document.cargo.vehicle_type", VehicleType.class, documentCargoModel, "vehicleType");

        //Тип транспортного средства - реквизиты
        TextField vehicleDetails = new TextField<String>("document.cargo.vehicle_details",
                new PropertyModel<String>(documentCargoModel, "vehicleDetails"));
        vehicleDetails.setRequired(true);
        form.add(vehicleDetails);

        //Список грузов
        final WebMarkupContainer cargoContainer = new WebMarkupContainer("document.cargo.cargo_container");
        cargoContainer.setOutputMarkupId(true);
        form.add(cargoContainer);

        final ListView cargoListView = new ListView<Cargo>("document.cargo.cargo_list",
                new PropertyModel<List<Cargo>>(documentCargoModel.getObject(), "cargos")){
            @Override
            protected void populateItem(final ListItem<Cargo> item) {
                addCargo(item);

                //Удалить
                AjaxSubmitLink deleteLink = new AjaxSubmitLink("document.cargo.delete", form) {

                    @Override
                    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                        int last_index = documentCargoModel.getObject().getCargos().size() - 1;
                        @SuppressWarnings({"unchecked"}) ListItem<Cargo> item = (ListItem) getParent();

                        //Copy childs from next list item and remove last 
                        for (int index = item.getIndex(); index < last_index; index++){
                            ListItem li = (ListItem)item.getParent().get(index);
                            ListItem li_next = (ListItem)item.getParent().get(index + 1);

                            li.removeAll();
                            //noinspection unchecked
                            li.setModelObject(li_next.getModelObject());

                            int size = li_next.size();
                            Component[] childs = new Component[size];
                            for (int i = 0; i < size; i++){
                                childs[i] = li_next.get(i);
                            }
                            li.add(childs);
                        }

                        documentCargoModel.getObject().getCargos().remove(item.getModelObject());
                        item.getParent().get(last_index).remove();

                        target.addComponent(cargoContainer);
                    }
                };
                deleteLink.setDefaultFormProcessing(false);

                item.add(deleteLink);
            }
        };

        //Добавить груз
        cargoListView.setReuseItems(true);
        cargoContainer.add(cargoListView);

        AjaxSubmitLink addCargoLink = new AjaxSubmitLink("document.cargo.cargo.add", form){

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                Cargo cargo = new Cargo();
                cargo.setDocumentCargo(documentCargoModel.getObject());
                documentCargoModel.getObject().getCargos().add(cargo);
                target.addComponent(cargoContainer);
            }
        };
        addCargoLink.setDefaultFormProcessing(false);

        cargoContainer.add(addCargoLink);

        //Отравитель
        addDropDownChoice(form, "document.cargo.cargo_sender", CargoSender.class, documentCargoModel, "cargoSender");

        //Получатель
        addDropDownChoice(form, "document.cargo.cargo_receiver", CargoReceiver.class, documentCargoModel, "cargoReceiver");

        //Производитель
        addDropDownChoice(form, "document.cargo.producer", Producer.class, documentCargoModel, "producer");

        //Реквизиты акта задержания груза
        TextField detentionDetails = new TextField<String>("document.cargo.detention_details",
                new PropertyModel<String>(documentCargoModel, "detentionDetails"));        
        form.add(detentionDetails);

        //Примечания
        TextArea details = new TextArea<String>("document.cargo.details",
                new PropertyModel<String>(documentCargoModel, "details"));
        form.add(details);
    }

    private <T extends IBook> DropDownChoice<T> addDropDownChoice(WebMarkupContainer container, String id, Class<T> bookClass, Object model, String property){
        List<T> list = null;

        try {
            list = bookViewDAO.getContent(bookClass);
        } catch (Exception e) {
            log.error("Ошибка загрузки списка справочников: " + bookClass, e);
        }

        DropDownChoice<T> ddcMovementTypes = new DropDownChoice<T>(id,
                new PropertyModel<T>(model, property), list,
                new IChoiceRenderer<T>(){

                    @Override
                    public Object getDisplayValue(T object) {
                        return BeanPropertyUtil.getLocalizablePropertyAsString(object.getNames(), localeDAO.systemLocale(), null);
                    }

                    @Override
                    public String getIdValue(T object, int index) {
                        return String.valueOf(object.getId());
                    }
                });

        ddcMovementTypes.setRequired(true);
        container.add(ddcMovementTypes);

        return ddcMovementTypes;
    }

    private void addCargo(final ListItem<Cargo> item){
        //Тип груза
        final DropDownChoice<CargoType> ddcCargoType = addDropDownChoice(item, "document.cargo.cargo_type", CargoType.class,item.getModelObject(), "cargoType");

        //Модель данных для видов груза
        LoadableDetachableModel<List<CargoMode>> cargoModeModel = new LoadableDetachableModel<List<CargoMode>>(){
            @Override
            protected List<CargoMode> load() {
                List<CargoMode> cargoModes = documentBean.getCargoModes(ddcCargoType.getModelObject());
                bookViewDAO.addLocalizationSupport(cargoModes);
                return cargoModes;
            }
        };

        //Вид груза
        final DropDownChoice<CargoMode> ddcCargoMode = new DropDownChoice<CargoMode>("document.cargo.cargo_mode",
                new PropertyModel<CargoMode>(item.getModelObject(), "cargoMode"),
                cargoModeModel,
                new IChoiceRenderer<CargoMode>(){

                    @Override
                    public Object getDisplayValue(CargoMode cargoMode) {
                        return BeanPropertyUtil.getLocalizablePropertyAsString(cargoMode.getNames(), localeDAO.systemLocale(), null)
                                + " (" + BeanPropertyUtil.getLocalizablePropertyAsString(cargoMode.getUnitType().getNames(), localeDAO.systemLocale(), null) + ")";
                    }

                    @Override
                    public String getIdValue(CargoMode cargoMode, int index) {
                        return String.valueOf(cargoMode.getId());
                    }
                });
        ddcCargoMode.setRequired(true);
        ddcCargoMode.setOutputMarkupId(true);
        item.add(ddcCargoMode);

        ddcCargoType.add(new AjaxFormComponentUpdatingBehavior("onchange"){

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                target.addComponent(ddcCargoMode);
            }
        });

        //Единицы измерения
        addDropDownChoice(item, "document.cargo.unit_type", UnitType.class, item.getModelObject(), "unitType");

        //Количество
        TextField<Integer> count = new TextField<Integer>("document.cargo.count",
                new PropertyModel<Integer>(item.getModelObject(), "count"));
        count.setRequired(true);
        item.add(count);

        //Реквизиты сертификата
        TextField<String> certificateDetails = new TextField<String>("document.cargo.certificate_detail",
                new PropertyModel<String>(item.getModelObject(), "certificateDetails"));
        certificateDetails.setRequired(true);
        item.add(certificateDetails);

        //Дата сертификата
        DatePicker<Date> certificateDate = new DatePicker<Date>("document.cargo.certificate_date",
                new PropertyModel<Date>(item.getModelObject(), "certificateDate"));
        certificateDate.setButtonImage("images/calendar.gif");
        certificateDate.setButtonImageOnly(true);
        certificateDate.setShowOn(DatePicker.ShowOnEnum.BOTH);
        certificateDate.setRequired(true);
        item.add(certificateDate);
    }

}