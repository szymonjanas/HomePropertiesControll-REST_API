package com.homePropertiesControl.HPC.restApi.model;

import com.fasterxml.uuid.Generators;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sensor {

    @Id
    private String id;
    private String name;
    private String type;
    private String location;
    private boolean state;
    private int level;

    public Sensor() {}
    public Sensor(String id,
                  String name,
                  String type,
                  String location,
                  int level) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        setLevel(level);
    }

    public Sensor(String name,
                  String type,
                  String location) {

        this.id = Generators.randomBasedGenerator().generate().toString();
        this.name = name;
        this.type = type;
        this.location = location;
        setLevel(0);
    }

    public void setLevel(int level) {
        this.state = level != 0;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public boolean isState() {
        return state;
    }

    public int getLevel() {
        return level;
    }

    public boolean getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
