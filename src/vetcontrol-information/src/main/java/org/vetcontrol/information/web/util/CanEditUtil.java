/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.information.web.util;

import java.io.Serializable;
import org.apache.wicket.Application;
import org.vetcontrol.book.BeanPropertyUtil;
import org.vetcontrol.web.security.SecurityRoles;
import org.vetcontrol.web.template.TemplateWebApplication;

/**
 *
 * @author Artem
 */
public final class CanEditUtil {

    private CanEditUtil(){}

    public static boolean canEdit(Serializable bookEntry) {
        TemplateWebApplication application = (TemplateWebApplication) Application.get();
        return application.hasAnyRole(SecurityRoles.INFORMATION_EDIT)
                && !(Boolean) BeanPropertyUtil.getPropertyValue(bookEntry, BeanPropertyUtil.getDisabledPropertyName());
    }

    public static boolean canEditDisabled(Serializable bookEntry){
        TemplateWebApplication application = (TemplateWebApplication) Application.get();
        return application.hasAnyRole(SecurityRoles.INFORMATION_EDIT)
                && (Boolean) BeanPropertyUtil.getPropertyValue(bookEntry, BeanPropertyUtil.getDisabledPropertyName());
    }
}
