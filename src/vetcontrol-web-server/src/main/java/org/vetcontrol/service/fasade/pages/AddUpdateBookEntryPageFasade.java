/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.vetcontrol.service.fasade.pages;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.vetcontrol.service.dao.books.IBookDAO;

/**
 *
 * @author Artem
 */
@Stateless(name="AddUpdateBookEntryPageFasade")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AddUpdateBookEntryPageFasade extends AbstractFasade {

    @EJB
    private IBookDAO bookDAO;

    public void saveOrUpdate(final Serializable bookEntry) {
        bookDAO.saveOrUpdate(bookEntry);
    }

}