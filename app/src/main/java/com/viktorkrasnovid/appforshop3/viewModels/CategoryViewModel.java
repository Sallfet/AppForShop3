package com.viktorkrasnovid.appforshop3.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    private LiveData<List<Category>> data;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Category>> getData() {
        if (data == null) {
            Context context = getApplication();
            data = AppDatabase.getDatabase(context).categoryDAO().getAllCategories();
        }

        return data;
    }
}
