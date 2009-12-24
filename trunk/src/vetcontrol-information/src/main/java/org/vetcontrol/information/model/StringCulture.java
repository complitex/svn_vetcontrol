package org.vetcontrol.information.model;
// Generated Dec 18, 2009 2:51:50 PM by Hibernate Tools 3.2.1.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * StringCulture generated by hbm2java
 */
@Entity
@Table(name = "stringculture")
public class StringCulture implements java.io.Serializable {

    private StringCultureId id;
    private String value;

    public StringCulture() {
    }

    public StringCulture(StringCultureId id) {
        this.id = id;
    }

    public StringCulture(StringCultureId id, String value) {
        this.id = id;
        this.value = value;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "id", column =
        @Column(name = "id", nullable = false)),
        @AttributeOverride(name = "locale", column =
        @Column(name = "locale", nullable = false, length = 2))})
    public StringCultureId getId() {
        return this.id;
    }

    public void setId(StringCultureId id) {
        this.id = id;
    }

    @Column(name = "value", length = 1024)
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


