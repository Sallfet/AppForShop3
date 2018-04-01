package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.Category;

@Dao
public interface CategoryDAO {

    @Insert
    public void insert(Category category);

    @Delete
    public void delete(Category category);

    @Update
    public void update(Category category);



}
