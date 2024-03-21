package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class billDetail extends AppCompatActivity {
    TextView txtOldElectric, txtNewElectric, txtUseElectric, txtWater, txtTotalRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);

        // Ánh xạ các thành phần giao diện
        txtOldElectric = findViewById(R.id.txtOldElectric);
        txtNewElectric = findViewById(R.id.txtNewElectric);
        txtUseElectric = findViewById(R.id.txtUseElectric);
        txtWater = findViewById(R.id.txtWater);
        txtTotalRent = findViewById(R.id.txtTotalRent);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String oldElectric = intent.getStringExtra("oldElectric");
        String newElectric = intent.getStringExtra("newElectric");
        int useElectric = intent.getIntExtra("useElectric", 0);
        int water = intent.getIntExtra("water", 0);
        int totalRent = intent.getIntExtra("totalRent", 0);

        // Hiển thị dữ liệu trong giao diện của billDetail
        txtOldElectric.setText("Số điện cũ: " + oldElectric);
        txtNewElectric.setText("Số điện mới: " + newElectric);
        txtUseElectric.setText("Điện đã sử dụng: " + useElectric);
        txtWater.setText("Tiền nước: " + water);
        txtTotalRent.setText("Tổng tiền: " + totalRent);
    }
}
