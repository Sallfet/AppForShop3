package com.viktorkrasnovid.appforshop3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.model.ProductViewModel;

import java.util.List;

public class ShoppingListCreating extends AppCompatActivity {

    AutoCompleteTextView productChoose;
    Button mic;
    Button addProduct;
    EditText count;
    Spinner measureType;
    EditText price;
    ListView creatingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_creating);

        creatingList = findViewById(R.id.creating_product_list);
        measureType = findViewById(R.id.measure_type);
        productChoose = findViewById(R.id.products);
        addProduct = findViewById(R.id.add_product);
        count = findViewById(R.id.count);
        price = findViewById(R.id.price);
        mic = findViewById(R.id.mic);

        LiveData<List<Product>> allProducts = ViewModelProviders.of(this).get(ProductViewModel.class).getData();

        allProducts.observe(this,prdcts -> {
            ArrayAdapter<Product> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, prdcts);
            productChoose.setAdapter(adapter);
        });

        productChoose.setOnItemClickListener((parent, view, position, id) -> {
            Product item = (Product)parent.getAdapter().getItem(position);
        });


    }
}
