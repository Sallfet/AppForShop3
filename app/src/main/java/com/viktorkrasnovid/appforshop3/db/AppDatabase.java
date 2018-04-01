package com.viktorkrasnovid.appforshop3.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.viktorkrasnovid.appforshop3.db.DAO.CategoryDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductListDAO;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;

@Database(entities = {Product.class, Category.class, ProductList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDAO productDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract ProductListDAO productListDAO();

}
