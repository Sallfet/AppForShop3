package com.viktorkrasnovid.appforshop3.viewModels;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider.NewInstanceFactory;
import android.support.annotation.NonNull;

public class ProductListWithProductsFactory extends NewInstanceFactory {

    private final Application application;
    private final long id;

    public ProductListWithProductsFactory(Application application, long id) {
        super();
        this.application = application;
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ProductListWithProductsViewModel.class) {
            return (T) new ProductListWithProductsViewModel(application, id);
        }
        return null;
    }
}
