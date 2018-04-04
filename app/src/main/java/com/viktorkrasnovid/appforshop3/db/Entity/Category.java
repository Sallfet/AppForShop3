package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private final String name;
    private final String color;

    public Category(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public static Category[] populateData() {
        return new Category[]{
                new Category("Фрукты", "Yellow"),
                new Category("Мясо", "Red")
        };
    }
}
