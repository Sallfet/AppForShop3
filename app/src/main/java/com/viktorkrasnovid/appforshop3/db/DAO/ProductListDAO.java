package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;

import java.util.List;

@Dao
public interface ProductListDAO {

    @Insert
    void insert(ProductList list);

    @Delete
    void delete(ProductList list);

    @Update
    void update(ProductList list);

    @Query("SELECT * FROM productlist WHERE kindId = :kindId")
    LiveData<List<ProductList>> getProductListsByKind(int kindId);

    @Query("SELECT * FROM productlist WHERE id = :id")
    LiveData<ProductList> getById(int id);
}
