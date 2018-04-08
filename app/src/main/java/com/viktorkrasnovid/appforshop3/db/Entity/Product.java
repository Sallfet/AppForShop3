package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
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
    private int count;
    private int measureId;

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
                new Product( "Apple", 1),
                new Product("Kolbasa", 2)
        };
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMeasureId() {
        return measureId;
    }

    public void setMeasureId(int measureId) {
        this.measureId = measureId;
    }


    public void incrementCount() {
        this.count++;
    }

    public void decrementCount() {
        if (this.count > 0) {
            this.count--;
        }
    }
}
