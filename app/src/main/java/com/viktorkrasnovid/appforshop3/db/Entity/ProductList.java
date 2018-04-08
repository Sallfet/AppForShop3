package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.viktorkrasnovid.appforshop3.model.ProductListKind;

@Entity()
public class ProductList {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private final String name;
    private final String description;
    private final int kindId;

    public ProductList(String name, String description, int kindId) {
        this.name = name;
        this.description = description;
        this.kindId = kindId;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getKindId() {
        return kindId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
