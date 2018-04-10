package com.viktorkrasnovid.appforshop3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.viktorkrasnovid.appforshop3.adapters.MyExpandableListAdapter;
import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.viewModels.ProductListWithProductsFactory;
import com.viktorkrasnovid.appforshop3.viewModels.ProductListWithProductsViewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingListActivity extends AppCompatActivity {

    List<List<Product>> groups;

    ExpandableListView shoppingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        shoppingList = findViewById(R.id.shopping_list);

        long productListId = getIntent().getLongExtra("ProductListId", 0);

        LiveData<List<Product>> data = ViewModelProviders.of(this, new ProductListWithProductsFactory(this.getApplication(), productListId)).get(ProductListWithProductsViewModel.class).getData();

        data.observe(this, products -> {
            MyExpandableListAdapter expandableListAdapter = new MyExpandableListAdapter(this, products);
            shoppingList.setAdapter(expandableListAdapter);
        });



    }


}
