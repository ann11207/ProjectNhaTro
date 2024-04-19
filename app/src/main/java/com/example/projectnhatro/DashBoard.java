package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectnhatro.fragments.HomeFragment;

public class DashBoard extends AppCompatActivity {

    ImageButton dsbBTN_logOut, dsbBTN_Cash, dsbBTN_Information;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        dsbBTN_logOut = findViewById(R.id.dashboard_LogOut);
        dsbBTN_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            _logedUser.clearLoggedInUser(DashBoard.this);
                    Intent intentLoged = new Intent(getApplication(), MainActivity.class);
                startActivity(intentLoged);
                finish();
            }
        });

        dsbBTN_Cash = findViewById(R.id.dashBoard_Cash);
        dsbBTN_Cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenDashBoardCash = new Intent(getApplication(), Cash.class);
                startActivity(intentOpenDashBoardCash);
            }
        });

        dsbBTN_Information = findViewById(R.id.dashBoard_Information);
        dsbBTN_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenDashBoarInformation = new Intent(getApplication(), information.class);
                startActivity(intentOpenDashBoarInformation);
            }
        });

    }

}