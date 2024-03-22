package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class billDetail extends AppCompatActivity {
    TextView txtOldElectric, txtNewElectric, txtUseElectric, txtWater, txtTotalRent;

    Button btn_Save;

DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);


        txtOldElectric = findViewById(R.id.txtOldElectric);
        txtNewElectric = findViewById(R.id.txtNewElectric);
        txtUseElectric = findViewById(R.id.txtUseElectric);
        txtWater = findViewById(R.id.txtWater);
        txtTotalRent = findViewById(R.id.txtTotalRent);


        Intent intent = getIntent();
        String oldElectric = intent.getStringExtra("oldElectric");
        String newElectric = intent.getStringExtra("newElectric");
        int useElectric = intent.getIntExtra("useElectric", 0);
        int water = intent.getIntExtra("water", 0);
        int totalRent = intent.getIntExtra("totalRent", 0);


        txtOldElectric.setText("Số điện cũ: " + oldElectric);
        txtNewElectric.setText("Số điện mới: " + newElectric);
        txtUseElectric.setText("Điện đã sử dụng: " + useElectric);
        txtWater.setText("Tiền nước: " + water);
        txtTotalRent.setText("Tổng tiền: " + totalRent);


        DB = new DBHelper(this);

        btn_Save = findViewById(R.id.btnBillDetail_Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String old_Electric = txtOldElectric.getText().toString().split(": ")[1];

             String new_Electric = txtNewElectric.getText().toString().split(": ")[1];

             String total_Rent = txtTotalRent.getText().toString().split(": ")[1];

                String use_Electric = txtUseElectric.getText().toString().split(": ")[1];

             try {
                 int _oldElectric = Integer.parseInt(old_Electric);
                 int _newElectric = Integer.parseInt(new_Electric);
                 int _totalRent = Integer.parseInt(total_Rent);
                 int _useElectric = Integer.parseInt(use_Electric);

                 boolean save = DB.saveBill(_oldElectric, _newElectric, _totalRent, _useElectric);

                 if (save) {
                     // Toast khi lưu thành công
                     Toast.makeText(getApplicationContext(), "Lưu thành công!", Toast.LENGTH_SHORT).show();
                 } else {
                     // Toast khi lưu không thành công
                     Toast.makeText(getApplicationContext(), "Lưu thất bại!", Toast.LENGTH_SHORT).show();
                 }
             } catch (NumberFormatException e) {
                 e.printStackTrace();
             }
            }
        });
    }


}
