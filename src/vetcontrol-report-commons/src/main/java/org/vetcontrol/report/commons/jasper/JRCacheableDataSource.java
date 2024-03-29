/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.report.commons.jasper;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import org.vetcontrol.report.commons.service.dao.AbstractReportDAO;

/**
 *
 * @author Artem
 */
public class JRCacheableDataSource<T extends Serializable> extends JRAbstractBeanDataSource {

    private static final int CACHE_SIZE = 50;
    private AbstractReportDAO<T> reportDAO;
    private int index;
    private T current;
//    private List<T> cache;
    private Iterator<T> iterator;
    private Map<String, Object> reportDAOParameters;
    private String sortProperty;
    private boolean isAscending;

    public JRCacheableDataSource(AbstractReportDAO<T> reportDAO, Map<String, Object> reportDAOParameters, 
            String sortProperty, boolean isAscending) {
        super(false);
        this.reportDAO = reportDAO;
        this.reportDAOParameters = reportDAOParameters;
        this.sortProperty = sortProperty;
        this.isAscending = isAscending;
    }

    @Override
    public void moveFirst() throws JRException {
        index = 0;
//        cache = null;
        iterator = null;
        current = null;
    }

    @Override
    public boolean next() throws JRException {
        if (index == 0) {
//            cache = reportDAO.getAll(reportDAOParameters, reportLocale, 0, CACHE_SIZE, sortProperty, isAscending);
            iterator = reportDAO.getAll(reportDAOParameters, 0, CACHE_SIZE, sortProperty, isAscending).iterator();
        }

        boolean hasNext = iterator.hasNext();
        if (!hasNext) {
//                cache = reportDAO.getAll(reportDAOParameters, reportLocale, index, CACHE_SIZE, sortProperty, isAscending);
            iterator = reportDAO.getAll(reportDAOParameters, index, CACHE_SIZE, sortProperty, isAscending).iterator();
            hasNext = iterator.hasNext();
        }

        if (hasNext) {
            current = iterator.next();
            index++;
        }
        return hasNext;
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        return getFieldValue(current, field);
    }
}
