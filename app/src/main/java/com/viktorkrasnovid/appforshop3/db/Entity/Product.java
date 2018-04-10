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
    private String name;
    private String notes;
    private long categoryId;
    private long count;
    private long measureId;
    private long price;

    //method for pre-populate DB
    public static Product[] populateDao(){
        Product apple = new Product();
        apple.setName("Apple");
        apple.setCategoryId(1);
        Product kolbasa = new Product();
        kolbasa.setName("Kolbasa");
        kolbasa.setCategoryId(2);

        return new Product[]{
                apple,
                kolbasa
        };
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void incrementCount() {
        this.count++;
    }

    public void decrementCount() {
        if (this.count > 0) {
            this.count--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(long measureId) {
        this.measureId = measureId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
