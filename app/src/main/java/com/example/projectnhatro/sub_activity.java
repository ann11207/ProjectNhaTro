package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class sub_activity extends AppCompatActivity {
    Button btn_Contact;
    private static final int REQUEST_CALL_PHONE = 1;

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

btn_Contact = findViewById(R.id.btnSubActivity_Contact);
        btn_Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = "0933010536";

                // Kiểm tra quyền CALL_PHONE
                if (ContextCompat.checkSelfPermission(sub_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(sub_activity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
                } else {
                    // Nếu quyền đã được cấp, thực hiện cuộc gọi
                    Intent intentOpenCall = new Intent(Intent.ACTION_DIAL);
                    intentOpenCall.setData(Uri.parse("tel:" + phoneNum));
                    startActivity(intentOpenCall);
                }
            }
        });

    }
}