package org.vetcontrol.sync.client.service;

import org.vetcontrol.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 26.02.2010 19:31:47
 */
public class SyncMessage implements Serializable{
    private Date date = DateUtil.getCurrentDate();
    private String name;
    private String message;

    public SyncMessage() {
    }

    public SyncMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
