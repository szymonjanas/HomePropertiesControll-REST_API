package com.homePropertiesControl.HPC.restApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

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

    public Motd(String message) {
        Random rand = new Random();
        this.id = rand.nextInt(999999) + 0;
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
