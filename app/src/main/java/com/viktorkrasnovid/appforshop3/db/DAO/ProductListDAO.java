package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;

@Dao
public interface ProductListDAO {

    @Insert
    public void insert(ProductList list);

    @Delete
    public void delete(ProductList list);

    @Update
    public void update(ProductList list);


}
