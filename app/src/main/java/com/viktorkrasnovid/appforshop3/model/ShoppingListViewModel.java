package com.viktorkrasnovid.appforshop3.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;

public class ShoppingListViewModel extends AndroidViewModel {

    private LiveData<ProductList> data;

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ProductList> getData() {
        if (data == null) {
            Context context = getApplication();
            data = AppDatabase.getDatabase(context).productListDAO().getById(ProductListKind.SHOPPING_LIST.getId());
        }

        return data;
    }
}
