package com.homePropertiesControl.HPC.restApi.Models;

import com.fasterxml.uuid.Generators;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Iterator;

@Entity
public class Sensor {

    @Id
    private String id = "";
    private String name = null;
    private String type = null;
    private String location = null;

    private boolean state = false;
    private int level = -1;

    public Sensor() {}

    public Sensor(String id,
                  String name,
                  String type,
                  String location,
                  int level,
                  boolean state) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.level = level;
        this.state = state;
    }

    public Sensor(Sensor sensor) {
        if (sensor.getId().length() == 0)
            this.id = Generators.randomBasedGenerator().generate().toString();
        else
            this.id = sensor.getId();
        this.name = sensor.getName();
        this.type = sensor.getType();
        this.location = sensor.getLocation();
        this.level = sensor.getLevel();
        this.state = sensor.getState();
    }

    public Sensor(JSONObject jsonObject){
        Iterator iter = jsonObject.keys();
        while(iter.hasNext()){
            String key = (String) iter.next();
            switch (key){
                case "id":
                    this.id =  (String) jsonObject.get(key);
                    break;
                case "name":
                    this.name = (String) jsonObject.get(key);
                    break;
                case "type":
                    this.type = (String) jsonObject.get(key);
                    break;
                case "location":
                    this.location = (String) jsonObject.get(key);
                    break;
                case "level":
                    this.level = (int) jsonObject.get(key);
                    break;
                case "state":
                    this.state = (boolean) jsonObject.get(key);
                    break;
            }
        }

    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setId(String id){ this.id = id;}

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

    public void setState(boolean state) {
        this.state = state;
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
