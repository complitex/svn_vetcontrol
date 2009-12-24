package org.vetcontrol.information.model;
// Generated Dec 18, 2009 2:51:50 PM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Generator generated by hbm2java
 */
@Entity
@Table(name = "generator")
public class Generator implements java.io.Serializable {

    private String generatorName;
    private long generatorValue;

    public Generator() {
    }

    public Generator(String generatorName, long generatorValue) {
        this.generatorName = generatorName;
        this.generatorValue = generatorValue;
    }

    @Id
    @Column(name = "generatorName", unique = true, nullable = false, length = 20)
    public String getGeneratorName() {
        return this.generatorName;
    }

    public void setGeneratorName(String generatorName) {
        this.generatorName = generatorName;
    }

    @Column(name = "generatorValue", nullable = false)
    public long getGeneratorValue() {
        return this.generatorValue;
    }

    public void setGeneratorValue(long generatorValue) {
        this.generatorValue = generatorValue;
    }
}


