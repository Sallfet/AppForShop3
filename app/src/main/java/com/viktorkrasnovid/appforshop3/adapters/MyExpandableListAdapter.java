package com.viktorkrasnovid.appforshop3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.viktorkrasnovid.appforshop3.R;
import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private List<ProductGroup> groups;
    private Context context;
    private LayoutInflater inflater;

    public MyExpandableListAdapter(Context context, List<Product> products) {
        this.groups = mapProductsToGroupProducts(products);
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groups.get(groupPosition).getProducts().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groups.get(groupPosition).getProducts().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groups.get(groupPosition).getProducts().get(childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.exp_group_item, null);
        }

        if (isExpanded){
            //Изменяем что-нибудь, если текущая Group раскрыта
        }
        else{
            //Изменяем что-нибудь, если текущая Group скрыта
        }

        TextView textGroup = convertView.findViewById(R.id.exp_group);
        ProductGroup group = (ProductGroup) getGroup(groupPosition);
        textGroup.setText(group.getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;

        Product p = (Product) getChild(groupPosition, childPosition);

        if (view == null) {
            view = this.inflater.inflate(R.layout.exp_child_item, null);
        }

        ((TextView) view.findViewById(R.id.exp_product_name)).setText(p.getName());
        ((TextView) view.findViewById(R.id.exp_product_count)).setText(String.valueOf(p.getCount()));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ProductGroup{
        private final List<Product> products;
        private final String name;

        public ProductGroup(String name, List<Product> products) {
            this.name = name;
            this.products = products;
        }

        public String getName() {
            return name;
        }

        public List<Product> getProducts() {
            return products;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }

            return this.name.equals(((ProductGroup) obj).name);
        }
    }

    private List<ProductGroup> mapProductsToGroupProducts(List<Product> products) {
        List<ProductGroup> res = new ArrayList<>();
        Map<Category, List<Product>> map = mapProductsToCategory(products);
        for (Map.Entry<Category, List<Product>> entry : map.entrySet()) {
            res.add(new ProductGroup(entry.getKey().getName(), entry.getValue()));
        }

        return res;
    }

    private Map<Category, List<Product>> mapProductsToCategory(List<Product> products) {
        Map<Category, List<Product>> res = new HashMap<>();

        for (Product p : products) {
            Category category = DBUtils.executeAndGet(() -> AppDatabase.getDatabase(this.context).categoryDAO().getById(p.getCategoryId()));

            if (res.get(category) == null) {
                List<Product> list = new ArrayList<>();
                list.add(p);
                res.put(category, list);
            } else {
                res.get(category).add(p);
            }
        }
        return res;
    }
}
