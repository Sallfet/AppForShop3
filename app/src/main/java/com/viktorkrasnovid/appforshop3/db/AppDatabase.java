package com.viktorkrasnovid.appforshop3.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.viktorkrasnovid.appforshop3.db.DAO.CategoryDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductListDAO;
import com.viktorkrasnovid.appforshop3.db.DAO.ProductListWithProductsDAO;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductListWithProducts;

import java.util.concurrent.Executors;

@Database(entities = {Product.class, Category.class, ProductList.class, ProductListWithProducts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDAO productDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract ProductListWithProductsDAO productListWithProductsDAO();
    public abstract ProductListDAO productListDAO();

    private static AppDatabase INSTANCE;

    public synchronized static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context context) {
        return  Room.databaseBuilder(context, AppDatabase.class, "ShoppingListDatabase1").addCallback(new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {//DB pre-populating
                        getDatabase(context).categoryDAO().insertAll(Category.populateData());
                        getDatabase(context).productDAO().insertAll(Product.populateDao());
                    }
                });
            }
        }).build();
    }
}
