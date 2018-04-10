package com.viktorkrasnovid.appforshop3.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;

import java.util.List;

public class ShoppingListAdapter extends ArrayAdapter<ProductList> {


    public ShoppingListAdapter(@NonNull Context context, int resource, @NonNull List<ProductList> objects) {
        super(context, resource, objects);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }
}
