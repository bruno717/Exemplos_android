package com.example.bruno.exemplorealm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by bruno.oliveira on 6/10/16.
 */
public class Guitar extends RealmObject {

    @PrimaryKey
    private Long id;
    private String name;
    private String color;
    //private String strings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*public String getStrings() {
        return strings;
    }

    public void setStrings(String strings) {
        this.strings = strings;
    }*/
}
