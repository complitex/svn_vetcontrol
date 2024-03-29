/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.report.service.dao;

import org.vetcontrol.report.commons.service.dao.AbstractReportDAO;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.vetcontrol.report.entity.RegionalControlReport;
import org.vetcontrol.web.security.SecurityRoles;

/**
 *
 * @author Artem
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@RolesAllowed({SecurityRoles.REGIONAL_REPORT})
public class RegionalControlReportDAO extends AbstractReportDAO<RegionalControlReport> {

    public static enum OrderBy {

        CARGO_ARRIVED("cargoArrived"),
        CARGO_TYPE("cargoTypeName"),
        CARGO_RECEIVER("cargoReceiverName"),
        CARGO_PRODUCER("cargoProducerName");
        private String name;

        private OrderBy(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public RegionalControlReportDAO() {
        super(RegionalControlReport.class);
    }

    @Override
    protected String prepareAllSQL(String sqlPattern, Map<String, Object> parameters, Locale reportLocale, String sortProperty, Boolean isAscending) {
        return MessageFormat.format(sqlPattern, sortProperty, isAscending ? "ASC" : "DESC");
    }
}
