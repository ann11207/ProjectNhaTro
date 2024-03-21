package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class bill extends AppCompatActivity {
    EditText oldElectric, newElectric;
    Integer water = 150000;
    Integer totalRent, useElectric;
    Spinner cashRent;
    TextView txt_Show;



    Button kq;

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

        cashRent = findViewById(R.id.spinerBill_cashRent);
        String[] cashPrice = {"4000000", "5000000"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cashPrice);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cashRent.setAdapter(adapter);


        oldElectric = findViewById(R.id.edtBill_oldElectric);
        newElectric = findViewById(R.id.edtBill_newElectric);

        kq = findViewById(R.id.ketqua);
        kq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

Intent intentBillDetail = new Intent(bill.this, billDetail.class);





                totalPrice();
                intentBillDetail.putExtra("oldElectric", oldElectric.getText().toString());
                intentBillDetail.putExtra("newElectric", newElectric.getText().toString());
                intentBillDetail.putExtra("useElectric", useElectric);
                intentBillDetail.putExtra("water", water);
                intentBillDetail.putExtra("totalRent", totalRent);

                // Chuyển đến billDetail
                startActivity(intentBillDetail);
            }
        });

txt_Show = findViewById(R.id.txtBill_Show);

        }

    public void totalPrice() {
        String old_Electric = oldElectric.getText().toString();
        String new_Electric = newElectric.getText().toString();
        String cash_Rent = cashRent.getSelectedItem().toString();



        if (!old_Electric.isEmpty() && !new_Electric.isEmpty() && !cash_Rent.isEmpty()) {
            int intOld_Electric = Integer.parseInt(old_Electric);
            int intNew_Electric = Integer.parseInt(new_Electric);
            int intCash_Rent = Integer.parseInt(cash_Rent);

             useElectric = intNew_Electric - intOld_Electric ;
            int priceElectric = useElectric * 3500;

            totalRent = priceElectric + intCash_Rent + water ;

        }

    }




}
