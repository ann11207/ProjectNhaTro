package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Cash extends AppCompatActivity {
    EditText edt_Namefirstlast, edt_Daterent, edt_Namehouse, edt_Numhouse;
    Button btn_add, btn_update, btn_delete, btn_view;
    ListView lsv_Show;

    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);

        edt_Namefirstlast = findViewById(R.id.edtCash_nameFirstLast);
        edt_Namehouse = findViewById(R.id.edtCash_nameHouse);
        edt_Daterent = findViewById(R.id.edtCash_Date);
        edt_Numhouse = findViewById(R.id.edtCash_Room);

        btn_add = findViewById(R.id.btnCash_addRenter);
        btn_update = findViewById(R.id.btnCash_Edit);
        btn_delete = findViewById(R.id.btnCash_Dele);
        btn_view = findViewById(R.id.btnCash_Show);

        lsv_Show = findViewById(R.id.lsvCash_showView);

        rentDB rentDB = new rentDB(Cash.this);

        edt_Daterent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                // Tạo DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(Cash.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Xử lý ngày được chọn
                                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                // Hiển thị ngày đã chọn trong EditText
                                edt_Daterent.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.show();
            }
        });

        DB = new DBHelper(this);
        btn_add.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String Namefl = edt_Namefirstlast.getText().toString();
                String Namehouse = edt_Namehouse.getText().toString();
                String Daterent = edt_Daterent.getText().toString();
                String Numhosue = edt_Numhouse.getText().toString();

                Boolean addrent = rentDB.addRenter(Namefl, Namehouse, Numhosue, Daterent);

                if (addrent == true)
                    Toast.makeText(Cash.this, "thêm thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Cash.this, "thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Namefl = edt_Namefirstlast.getText().toString();
                String Namehouse = edt_Namehouse.getText().toString();
                String Daterent = edt_Daterent.getText().toString();
                String Numhosue = edt_Numhouse.getText().toString();

                Boolean addrent = rentDB.updateRenter(Namefl, Namehouse, Numhosue, Daterent);

                if (addrent == true)
                    Toast.makeText(Cash.this, "up thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Cash.this, "thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Namefl = edt_Namefirstlast.getText().toString();

                Boolean deletrent = rentDB.deleteRenter(Namefl);

                if (deletrent == true)
                    Toast.makeText(Cash.this, "up thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Cash.this, "thất bại", Toast.LENGTH_SHORT).show();
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = rentDB.getRenter();
                if (res.getCount() == 0) {
                    Toast.makeText(Cash.this, "Không có ", Toast.LENGTH_SHORT).show();
                    return;
                }

                ArrayList<String> renterList = new ArrayList<>();
                while (res.moveToNext()) {
                    // Construct the data string for each row
                    String data = "ID: " + res.getString(0) + "\n"
                             +"Số phòng: " + res.getString(1) + "\n"
                            + "Họ tên người thuê: " + res.getString(3) + "\n"
                            + "Ngày thuê: " + res.getString(4) + "\n";
                    // Add the data string to the ArrayList
                    renterList.add(data);
                }
                res.close();


                ArrayAdapter<String> adapter = new ArrayAdapter<>(Cash.this, android.R.layout.simple_list_item_1, renterList);
                lsv_Show.setAdapter(adapter);
            }
        });
    }
}

