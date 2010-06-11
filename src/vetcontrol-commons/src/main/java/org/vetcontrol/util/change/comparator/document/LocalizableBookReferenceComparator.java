/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.util.change.comparator.document;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.entity.Localizable;
import org.vetcontrol.entity.Change;
import org.vetcontrol.util.change.comparator.PropertyComparator;

/**
 *
 * @author Artem
 */
public final class LocalizableBookReferenceComparator extends PropertyComparator<Localizable> {

    private static final Logger log = LoggerFactory.getLogger(LocalizableBookReferenceComparator.class);

    private Locale systemLocale;

    public LocalizableBookReferenceComparator(String propertyName, Locale systemLocale) {
        super(propertyName);
        this.systemLocale = systemLocale;

    }

    private static String dysplayPropertyValue(Localizable value, Locale systemLocale) {
        if (value == null) {
            return "null";
        }
        return value.getDisplayName(systemLocale, systemLocale);
    }

    @Override
    public Set<Change> compare(Localizable oldValue, Localizable newValue) {
        if ((oldValue == null) && (newValue == null)) {
            //property value wasn't changed.
            return Collections.emptySet();
        }

        String oldValueAsString = dysplayPropertyValue(oldValue, systemLocale);
        String newValueAsString = dysplayPropertyValue(newValue, systemLocale);

        if (oldValue == null || newValue == null) {
            //property value was changed
            Change change = new Change();
            change.setPropertyName(getPropertyName());
            change.setOldValue(oldValueAsString);
            change.setNewValue(newValueAsString);
            return Collections.singleton(change);
        }

        //the both old value and new value are not null.
        if (!oldValue.getId().equals(newValue.getId())) {
            Change change = new Change();
            change.setPropertyName(getPropertyName());
            change.setOldValue(oldValueAsString);
            change.setNewValue(newValueAsString);
            return Collections.singleton(change);
        }

        return Collections.emptySet();
    }
}
