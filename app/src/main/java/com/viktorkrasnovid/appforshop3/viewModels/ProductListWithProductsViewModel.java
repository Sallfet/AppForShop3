package com.viktorkrasnovid.appforshop3.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;

import java.util.List;

public class ProductListWithProductsViewModel extends AndroidViewModel {

    LiveData<List<Product>> data;
    private final long id;

    public ProductListWithProductsViewModel(@NonNull Application application, long id) {
        super(application);
        this.id = id;
    }

    public LiveData<List<Product>> getData() {
        return DBUtils.executeAndGet(() -> AppDatabase.getDatabase(getApplication()).productListWithProductsDAO().getAllProductsByProductListId(id));
    }
}
