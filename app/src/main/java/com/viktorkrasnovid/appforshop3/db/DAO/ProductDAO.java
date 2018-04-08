package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.Product;

import java.util.List;

@Dao
public interface ProductDAO {

    @Delete
    void delete(Product product);

    @Update
    void update(Product product);

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM product WHERE id = :id")
    Product getById(int id);

    @Query("SELECT * FROM product WHERE name = :name")
    Product getByName(String name);

    @Insert
    long[] insertAll(Product... products);

    @Insert
    long insert(Product product);
}
