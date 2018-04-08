package com.viktorkrasnovid.appforshop3.db.Entity;

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

    public final int productId;
    public final int productListId;

    public ProductListWithProducts(int productId, int productListId) {
        this.productId = productId;
        this.productListId = productListId;
    }
}
