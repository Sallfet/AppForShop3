package com.viktorkrasnovid.appforshop3.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.viktorkrasnovid.appforshop3.db.DAO.CategoryDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductListDAO;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductListProductJoin;

@Database(entities = {Product.class, Category.class, ProductList.class, ProductListProductJoin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDAO productDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract ProductListProductJoin productListProductJoin();
    public abstract ProductListDAO productListDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "ShoppingListDatabase").build();
        }
        return INSTANCE;
    }
}
