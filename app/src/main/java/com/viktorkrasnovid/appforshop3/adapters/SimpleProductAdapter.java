package com.viktorkrasnovid.appforshop3.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.viktorkrasnovid.appforshop3.R;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;

import java.util.List;

public class SimpleProductAdapter extends BaseAdapter {

    private List<Product> products;
    private LayoutInflater inflater;

    public SimpleProductAdapter(Context context, List<Product> productList) {
        this.products = productList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        Product p = (Product) getItem(position);

        if (view == null) {
            view = this.inflater.inflate(R.layout.product_choose_item, parent, false);
        }



        ((TextView) view.findViewById(R.id.product_name)).setText(p.getName());
        ((TextView) view.findViewById(R.id.product_count)).setText(String.valueOf(p.getCount()));
        ((Button) (view.findViewById(R.id.decrementProduct))).setOnClickListener(v -> {
            p.decrementCount();
            notifyDataSetChanged();//todo replace for DiffUtil
        });


        return view;
    }
}
