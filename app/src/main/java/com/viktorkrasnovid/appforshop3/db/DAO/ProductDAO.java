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

    @Insert
    void insert(Product product);

    @Delete
    void delete(Product product);

    @Update
    void update(Product product);

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM product WHERE id = :id")
    LiveData<Product> getById(int id);
}
