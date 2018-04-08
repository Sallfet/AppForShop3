package com.viktorkrasnovid.appforshop3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TypeNewShoppingListName extends AppCompatActivity {

    TextView okListName;
    EditText namePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_new_shopping_list_name);

        namePicker = findViewById(R.id.name_picker);

        okListName = findViewById(R.id.ok_name_button);

        okListName.setOnClickListener(v -> {
            Intent intent = new Intent(this, ShoppingListCreating.class);
            intent.putExtra("listName", namePicker.getText().toString());
            startActivity(intent);
        });
    }
}
