package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectnhatro.fragments.HomeFragment;

public class DashBoard extends AppCompatActivity {

    ImageButton dsbBTN_logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        dsbBTN_logOut = findViewById(R.id.dashboard_LogOut);

        dsbBTN_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            _logedUser.clearLoggedInUser(DashBoard.this);
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}