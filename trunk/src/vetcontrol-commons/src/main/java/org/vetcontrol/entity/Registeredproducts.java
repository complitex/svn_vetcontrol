package org.vetcontrol.entity;
// Generated Dec 21, 2009 12:17:35 PM by Hibernate Tools 3.2.1.GA

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.vetcontrol.util.book.entity.annotation.BookReference;
import org.vetcontrol.util.book.entity.annotation.MappedProperty;

/**
 * Registeredproducts generated by hbm2java
 */
@Entity
@Table(name = "registeredproducts")
public class Registeredproducts implements java.io.Serializable {

    private Integer id;
    private long name;
    private long classificator;
    private String vendor;
    private String regnumber;
    private Date date;

    public Registeredproducts() {
    }

    public Registeredproducts(String vendor, String regnumber, Date date) {
        this.vendor = vendor;
        this.regnumber = regnumber;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public long getName() {
        return this.name;
    }

    public void setName(long name) {
        this.name = name;
    }

    @Column(name = "classificator", nullable = false)
    public long getClassificator() {
        return this.classificator;
    }

    public void setClassificator(long classificator) {
        this.classificator = classificator;
    }

    @Column(name = "vendor", nullable = false, length = 50)
    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Column(name = "regnumber", nullable = false, length = 50)
    public String getRegnumber() {
        return this.regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false, length = 10)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    private List<StringCulture> names = new ArrayList<StringCulture>();

    /**
     * Get the value of names
     *
     * @return the value of names
     */
    @MappedProperty("name")
    @Transient
    @Column(length = 10, nullable = false)
    public List<StringCulture> getNames() {
        return names;
    }

    /**
     * Set the value of names
     *
     * @param names new value of names
     */
    public void setNames(List<StringCulture> names) {
        this.names = names;
    }

    public void addName(StringCulture name) {
        names.add(name);
    }
    private List<StringCulture> classificators = new ArrayList<StringCulture>();

    /**
     * Get the value of classificators
     *
     * @return the value of classificators
     */
    @MappedProperty("classificator")
    @Transient
    @Column(length = 10, nullable = false)
    public List<StringCulture> getClassificators() {
        return classificators;
    }

    /**
     * Set the value of classificators
     *
     * @param classificators new value of classificators
     */
    public void setClassificators(List<StringCulture> classificators) {
        this.classificators = classificators;
    }

    public void addClassificator(StringCulture classificator) {
        classificators.add(classificator);
    }
    private CountryBook country;

    /**
     * Get the value of referencedCountry
     *
     * @return the value of referencedCountry
     */
    @BookReference(referencedProperty = "names")
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "country", nullable = false)
    public CountryBook getCountry() {
        return country;
    }

    /**
     * Set the value of referencedCountry
     *
     * @param referencedCountry new value of referencedCountry
     */
    public void setCountry(CountryBook referencedCountry) {
        this.country = referencedCountry;
    }
}


