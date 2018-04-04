package com.viktorkrasnovid.appforshop3.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private LiveData<List<Product>> data;

    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getData() {
        if (data == null) {
            Context context = getApplication();
            data = AppDatabase.executeAndGet(() -> AppDatabase.getDatabase(context).productDAO().getAllProducts());
        }
        return data;
    }
}
