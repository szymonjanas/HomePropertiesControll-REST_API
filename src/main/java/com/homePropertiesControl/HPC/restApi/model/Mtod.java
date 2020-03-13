package com.homePropertiesControl.HPC.restApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mtod {

    @Id
    private String id;
    private String message;

    public Mtod() {}

    public Mtod(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
