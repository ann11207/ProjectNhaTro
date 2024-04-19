package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.projectnhatro.fragments.HomeFragment;

public class loadingStart extends AppCompatActivity {

    LottieAnimationView loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_start);

        loading = findViewById(R.id.loading_Lotti);

        loading.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentLoading = new Intent( getApplicationContext(), HomeFragment.class);
                startActivity(intentLoading);
            }
        }, 5000);
    }
}