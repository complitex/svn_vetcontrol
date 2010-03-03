/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.report.util.movementtypes;

/**
 *
 * @author Artem
 */
public class CellFormatter {

    public static String format(Number data, String unitTypeName) {
        long value = data.longValue();
        if (value == 0) {
            return "";
        }
        return value + " " + unitTypeName;
    }
}
