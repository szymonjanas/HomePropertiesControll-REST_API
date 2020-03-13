package com.homePropertiesControl.HPC.restApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Motd {

    @Id
    private Integer id;
    private String message;

    public Motd() {}

    public Motd(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
