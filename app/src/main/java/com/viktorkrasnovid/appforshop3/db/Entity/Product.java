package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = {
@ForeignKey(entity = Category.class,
parentColumns = "id",
childColumns = "categoryId")})
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private final String name;
    private final long categoryId;

    public Product(String name, long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    //method for pre-populate DB
    public static Product[] populateDao(){
        return new Product[]{
                new Product( "Яблоки", 1),
                new Product("Колбаса", 2)
        };
    }

    @Override
    public String toString() {
        return this.name;
    }


}
