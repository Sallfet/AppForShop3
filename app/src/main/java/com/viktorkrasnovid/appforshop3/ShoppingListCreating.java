package com.viktorkrasnovid.appforshop3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.viktorkrasnovid.appforshop3.adapters.SimpleProductAdapter;
import com.viktorkrasnovid.appforshop3.db.AppDatabase;
import com.viktorkrasnovid.appforshop3.db.DBUtils;
import com.viktorkrasnovid.appforshop3.db.Entity.Product;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductList;
import com.viktorkrasnovid.appforshop3.db.Entity.ProductListWithProducts;
import com.viktorkrasnovid.appforshop3.model.ProductListKind;
import com.viktorkrasnovid.appforshop3.viewModels.ProductViewModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingListCreating extends AppCompatActivity {

    TextView productChoose;
    ListView productList;
    Button mic;
    ProductList newProductList;
    LiveData<List<Product>> data;
    Set<Product> selectedProducts = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_creating);
        String listName = getIntent().getStringExtra("listName");
        this.newProductList = new ProductList(listName, "", ProductListKind.SHOPPING_LIST.getId());

        this.productChoose = findViewById(R.id.products_autocomplite);
        this.productList = findViewById(R.id.creating_product_list);

        this.data = ViewModelProviders.of(this).get(ProductViewModel.class).getData();
        this.data.observe(this, products -> {
            SimpleProductAdapter productsAdapter = new SimpleProductAdapter(this, products);
            productList.setAdapter(productsAdapter);
        });

        this.productList.setOnItemClickListener((parent, view, position, id) -> {
            Product p = (Product) parent.getAdapter().getItem(position);
            p.incrementCount();
            selectedProducts.add(p);
            ((SimpleProductAdapter) parent.getAdapter()).notifyDataSetChanged();//todo replace for DiffUtils or move to adapter
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //todo set description to a newProductList
        Long productListId = DBUtils.executeAndGet(() -> AppDatabase.getDatabase(this).productListDAO().insert(this.newProductList));

        for (Product product : selectedProducts) {
            ProductListWithProducts list = new ProductListWithProducts();//todo leave all except productid,
            list.setProductId(product.getId());
            list.setProductListId(productListId);
            list.setProductCount(product.getCount());
            list.setProductMeasureId(product.getMeasureId());
            list.setProductNotes(product.getNotes() == null ? "" : product.getNotes());
            DBUtils.execute(() -> AppDatabase.getDatabase(this).productListWithProductsDAO().insert(list));
        }
    }
}
