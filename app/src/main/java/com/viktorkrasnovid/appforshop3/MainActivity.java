package com.viktorkrasnovid.appforshop3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.viewModels.ShoppingListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView shopingListsList = findViewById(R.id.all_product_lists);
        LiveData<List<ProductList>> testData = ViewModelProviders.of(this).get(ShoppingListViewModel.class).getData();

        testData.observe(this, products -> {
            ArrayAdapter<ProductList> testAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, products);
            shopingListsList.setAdapter(testAdapter);
        });

        shopingListsList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, ShoppingListActivity.class);
            intent.putExtra("ProductListId", id);
        });

        FloatingActionButton testButton = findViewById(R.id.add_new_shopping_list);

        testButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, TypeNewShoppingListName.class);
            startActivity(intent);
        });

    }
}
