package com.viktorkrasnovid.appforshop3.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;

import com.viktorkrasnovid.appforshop3.R;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductAdapter extends ArrayAdapter<Product> {

    private List<Product> products;
    private List<Product> list;
    private LayoutInflater inflater;

    public SimpleProductAdapter(Context context,int resource, List<Product> productList) {
        super(context, resource, productList);
        this.products = productList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        Product p = getItem(position);

        if (view == null) {
            view = this.inflater.inflate(R.layout.product_choose_item, parent, false);
        }


        ((TextView) view.findViewById(R.id.product_name)).setText(p.getName());
        ((TextView) view.findViewById(R.id.product_count)).setText(String.valueOf(p.getCount()));
        (view.findViewById(R.id.decrementProduct)).setOnClickListener(v -> {
            long count = p.decrementCountAndGet();
            updateView(position, parent, count);
        });


        return view;
    }

    public void updateView(int index, ViewGroup parent, long count){
        ListView listView = (ListView) parent;

        View v = listView.getChildAt(index - listView.getFirstVisiblePosition());

        if(v == null)
            return;

        TextView textView = v.findViewById(R.id.product_count);

        textView.setText(String.valueOf(count));
        System.out.println("Data changed!");
    }

    @Override
    public Filter getFilter() {//fixme - case: type letters witch productc contais then type letter out of word when erase it - list is empty

        return new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                products = (List<Product>) results.values;
                sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Product> FilteredArrList = new ArrayList<>();

                if (list == null) {
                    list = new ArrayList<>(products);
                }

                if (constraint == null || constraint.length() == 0) {

                    results.count = list.size();
                    results.values = list;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < products.size(); i++) {
                        Product data = products.get(i);
                        if (data.getName().toLowerCase().contains(constraint.toString())) {
                            FilteredArrList.add(data);
                        }
                    }

                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
    }
}
