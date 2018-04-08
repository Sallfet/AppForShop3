package com.viktorkrasnovid.appforshop3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.viktorkrasnovid.appforshop3.adapters.SimpleProductAdapter;
import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductListWithProducts;
import com.viktorkrasnovid.appforshop3.model.Measure;
import com.viktorkrasnovid.appforshop3.model.ProductListKind;
import com.viktorkrasnovid.appforshop3.model.ProductViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingListCreating extends AppCompatActivity {

    TextView productChoose;
    ListView productList;
    Button mic;
    ProductList newProductList;
    LiveData<List<Product>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_creating);
        String listName = getIntent().getStringExtra("listName");
        this.newProductList = new ProductList(listName, "", ProductListKind.SHOPPING_LIST.getId());

        productChoose = findViewById(R.id.products_autocomplite);
        productList = findViewById(R.id.creating_product_list);

        data = ViewModelProviders.of(this).get(ProductViewModel.class).getData();
        data.observe(this, products -> {
            SimpleProductAdapter productsAdapter = new SimpleProductAdapter(this, products);
            productList.setAdapter(productsAdapter);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //todo set description to a newProductList
        Long productListId = DBUtils.executeAndGet(() -> AppDatabase.getDatabase(this).productListDAO().insert(this.newProductList));

        for (Product product : data.getValue()) {
            if (product.getCount() > 0) {
                DBUtils.execute(() -> AppDatabase.getDatabase(this).productListWithProductsDAO().insert(new ProductListWithProducts(product.getId(), productListId)));
            }
        }
    }
}
