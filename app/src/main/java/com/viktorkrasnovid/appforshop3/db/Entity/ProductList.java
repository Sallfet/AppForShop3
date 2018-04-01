package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.viktorkrasnovid.appforshop3.model.ProductListKind;

@Entity()
public class ProductList {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private final String name;
    private final String description;
    private final int kindId;

    public ProductList(String name, String description, ProductListKind kind) {
        this.name = name;
        this.description = description;
        this.kindId = kind.getId();
    }

    public long getId() {
        return id;
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
}
