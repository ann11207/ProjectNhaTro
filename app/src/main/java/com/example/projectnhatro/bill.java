package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class bill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("selectedItem");
        // Hiển thị dữ liệu trong TextView
        TextView txtSelectedItem = findViewById(R.id.txtBill_SelectedItem);
        txtSelectedItem.setText(selectedItem);


        }
    }
