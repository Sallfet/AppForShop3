package com.viktorkrasnovid.appforshop3.db.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(tableName = "productlist_product_join",
        primaryKeys = {"productId", "productListId"},
        foreignKeys = {@ForeignKey(entity = Product.class,
                                   parentColumns = "id",
                                   childColumns = "productId"),
                       @ForeignKey(entity = ProductList.class,
                                   parentColumns = "id",
                                   childColumns = "productListId")})
public class ProductListWithProducts {

    public long productId;
    public long productListId;
    public long count;
    public long measureId;
    public String notes;

    public long getProductId() {
        return productId;
    }

    public long getProductListId() {
        return productListId;
    }

    public long getProductCount() {
        return count;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setProductListId(long productListId) {
        this.productListId = productListId;
    }

    public void setProductCount(long productCount) {
        this.count = productCount;
    }

    public long getProductMeasureId() {
        return measureId;
    }

    public void setProductMeasureId(long productMeasureId) {
        this.measureId = productMeasureId;
    }

    public String getProductNotes() {
        return notes;
    }

    public void setProductNotes(String productNotes) {
        this.notes = productNotes;
    }
}
