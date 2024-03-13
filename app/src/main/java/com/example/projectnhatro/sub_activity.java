package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class sub_activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        int productImageResource = getIntent().getIntExtra("product_image", 0);
        String productName = getIntent().getStringExtra("product_name");

        // Hiển thị dữ liệu lên giao diện của SubActivity
        ImageView imageViewProduct = findViewById(R.id.imageViewsub);
        TextView textViewProductName = findViewById(R.id.textView_NameProductsub);

        imageViewProduct.setImageResource(productImageResource);
        textViewProductName.setText(productName);


    }
}