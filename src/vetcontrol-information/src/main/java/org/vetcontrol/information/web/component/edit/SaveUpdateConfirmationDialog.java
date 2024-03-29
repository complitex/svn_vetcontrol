/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.information.web.component.edit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.ui.dialog.Dialog;

/**
 *
 * @author Artem
 */
public abstract class SaveUpdateConfirmationDialog extends Panel {

    private Dialog dialog;

    public SaveUpdateConfirmationDialog(String id) {
        super(id);
        init();
    }

    private void init() {
        add(CSSPackageResource.getHeaderContribution(SaveUpdateConfirmationDialog.class, SaveUpdateConfirmationDialog.class.getSimpleName() + ".css"));

        dialog = new Dialog("dialog");
        dialog.setModal(true);
        dialog.setWidth(600);
//        dialog.setCloseOnEscape(false);
//        dialog.setOpenEvent(JsScopeUiEvent.quickScope("$('.ui-dialog-titlebar-close').hide()"));

        Link update = new Link("update") {

            @Override
            public void onClick() {
                update();
            }
        };
        Link createNew = new Link("createNew") {

            @Override
            public void onClick() {
                createNew();
            }
        };
        dialog.add(update);
        dialog.add(createNew);
        add(dialog);
    }

    public abstract void update();

    public abstract void createNew();

    public void open(AjaxRequestTarget target) {
        dialog.open(target);
    }
}
