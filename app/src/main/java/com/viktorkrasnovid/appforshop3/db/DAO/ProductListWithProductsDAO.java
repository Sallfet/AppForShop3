package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductListWithProducts;

import java.util.List;

@Dao
public interface ProductListWithProductsDAO {

    @Insert
    void insert(ProductListWithProducts join);

    @Update
    void update(ProductListWithProducts join);

    @Delete
    void delete(ProductListWithProducts join);

    @Query("SELECT productId, productCount, productId, name FROM product INNER JOIN productlist_product_join on product.id = productlist_product_join.productId WHERE productListId = :id")//todo understand which column needs in select
    LiveData<List<Product>> getAllProductsByProductListId(long id);

    @Query("SELECT * FROM productlist INNER JOIN productlist_product_join on id = productlistId WHERE productlist.kindId = :kind")
    LiveData<List<ProductList>> getAllListsByKind(long kind);


}
