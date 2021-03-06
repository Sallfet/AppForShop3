package com.viktorkrasnovid.appforshop3.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.model.ProductListKind;

import java.util.List;

public class ShoppingListViewModel extends AndroidViewModel {

    private LiveData<List<ProductList>> data;

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<ProductList>> getData() {
        if (data == null) {
            Context context = getApplication();
            data = DBUtils.executeAndGet(() -> AppDatabase.getDatabase(context).productListDAO().getProductListsByKind(ProductListKind.SHOPPING_LIST.getId()));
        }

        return data;
    }
}
