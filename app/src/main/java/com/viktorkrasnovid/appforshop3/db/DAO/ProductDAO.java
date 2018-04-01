package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.Product;

@Dao
public interface ProductDAO {

    @Insert
    public void insert(Product product);

    @Delete
    public void delete(Product product);

    @Update
    public void update(Product product);


}
