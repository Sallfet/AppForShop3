package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys =
@ForeignKey(entity = Category.class,
parentColumns = "id",
childColumns = "categoryId"))
public class Product {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private final String name;
    private final long categoryId;

    public Product(String name, long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCategoryId() {
        return categoryId;
    }
}
