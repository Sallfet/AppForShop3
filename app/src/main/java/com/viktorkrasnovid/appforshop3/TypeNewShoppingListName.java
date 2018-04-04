package com.viktorkrasnovid.appforshop3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeNewShoppingListName extends AppCompatActivity {

    Button okNameButton;
    Button cancelNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_new_shopping_list_name);

        okNameButton = findViewById(R.id.okNameButton);
        cancelNameButton = findViewById(R.id.cancelNameButton);

        okNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
