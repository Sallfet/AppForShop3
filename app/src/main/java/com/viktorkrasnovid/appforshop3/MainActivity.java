package com.viktorkrasnovid.appforshop3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.Category;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductListWithProducts;
import com.viktorkrasnovid.appforshop3.model.ProductViewModel;
import com.viktorkrasnovid.appforshop3.model.ShoppingListViewModel;

import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView testList = findViewById(R.id.all_product_lists);
        LiveData<List<ProductList>> testData = ViewModelProviders.of(this).get(ShoppingListViewModel.class).getData();

        testData.observe(this, products -> {
            ArrayAdapter<ProductList> testAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, products);
            testList.setAdapter(testAdapter);
        });

        FloatingActionButton testButton = findViewById(R.id.add_new_shopping_list);

        testButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, TypeNewShoppingListName.class);
            startActivity(intent);
        });

    }
}
