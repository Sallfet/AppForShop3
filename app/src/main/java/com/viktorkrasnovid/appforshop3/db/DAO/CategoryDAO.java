package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.viktorkrasnovid.appforshop3.db.Entity.Category;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Delete
    void delete(Category category);

    @Update
    void update(Category category);

    @Query("SELECT * FROM category")
    LiveData<List<Category>> getAllCategories();

    @Query("SELECT * FROM category WHERE id = :id")
    Category getById(int id);

    @Insert
    long[] insertAll(Category... categories);

    @Insert
    long insert(Category category);
}
