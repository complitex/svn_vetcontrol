package org.vetcontrol.entity;

import java.io.Serializable;
import org.vetcontrol.util.book.entity.annotation.MappedProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 12.01.2010 14:46:58
 *
 * 	места таможенного оформления грузов
 */
@Entity
@Table(name = "customs_point")
public class CustomsPoint implements Serializable {

    private Integer id;
    private Long name;
    private List<StringCulture> names = new ArrayList<StringCulture>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    @Transient
    @MappedProperty("name")
    @Column(length = 20, nullable = false)
    public List<StringCulture> getNames() {
        return names;
    }

    public void setNames(List<StringCulture> names) {
        this.names = names;
    }
}