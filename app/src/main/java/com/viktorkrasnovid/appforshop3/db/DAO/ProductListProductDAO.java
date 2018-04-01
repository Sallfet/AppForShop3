package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.ProductListProductJoin;

@Dao
public interface ProductListProductDAO {

    @Insert
    public void insert(ProductListProductJoin join);

    @Update
    public void update(ProductListProductJoin join);

    @Delete
    public void delete(ProductListProductJoin join);


}
