package org.vetcontrol.model;
// Generated Dec 17, 2009 12:53:27 PM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CulturestringId generated by hbm2java
 */
@Embeddable
public class CultureStringId implements java.io.Serializable {

    private int id;
    private String locale;

    public CultureStringId() {
    }

    public CultureStringId(String locale) {
        this.locale = locale;
    }

    @Column(name = "id", nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int stringId) {
        this.id = stringId;
    }

    @Column(name = "locale", nullable = false, length = 2)
    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof CultureStringId)) {
            return false;
        }
        CultureStringId castOther = (CultureStringId) other;

        return (this.getId() == castOther.getId())
                && ((this.getLocale() == castOther.getLocale()) || (this.getLocale() != null && castOther.getLocale() != null && this.getLocale().equals(castOther.getLocale())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + (getLocale() == null ? 0 : this.getLocale().hashCode());
        return result;
    }
}


