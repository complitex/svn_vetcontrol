/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.vetcontrol.service.dao;

import java.util.List;
import java.util.Locale;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import org.vetcontrol.book.ShowBooksMode;

/**
 *
 * @author Artem
 */
@Local
public interface IBookViewDAO {

    <T> List<T> getContent(T example, int first, int count, String sortProperty, boolean isAscending, Locale locale, ShowBooksMode showBooksMode);

    <T> List<T> getContent(Class<T> bookClass, ShowBooksMode showBooksMode);

    <T> Long size(T example, ShowBooksMode showBooksMode);

    void addLocalizationSupport(Object entity);

    void addLocalizationSupport(List<?> entities);

    void setEntityManager(EntityManager em);

}
