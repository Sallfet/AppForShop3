package com.viktorkrasnovid.appforshop3.db.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.viktorkrasnovid.appforshop3.db.relations.CategoryWithProducts;

import java.util.List;

@Dao
public interface CategoryWithProductsDAO {

    @Query("SELECT * FROM category")
    public List<CategoryWithProducts> getCategoriesWithProducts();
}
