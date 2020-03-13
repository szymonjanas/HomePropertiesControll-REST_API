package com.homePropertiesControl.HPC.restApi.model;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Iterator;

@Entity
public class Complains {

    @Id
    private String id;
    private String type;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    public Complains() {}

    public Complains(String id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public Complains(JSONObject jsonObject) {
        Iterator iter = jsonObject.keys();
        while(iter.hasNext()){
            String key = (String) iter.next();
            switch (key){
                case "id":
                    this.id =  (String) jsonObject.get(key);
                    break;
                case "type":
                    this.type =  (String) jsonObject.get(key);
                    break;
                case "content":
                    this.content =  (String) jsonObject.get(key);
                    break;
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
