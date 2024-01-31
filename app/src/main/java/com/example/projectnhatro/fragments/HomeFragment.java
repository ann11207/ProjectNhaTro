package com.example.projectnhatro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectnhatro.R;

public class HomeFragment extends Fragment {

Button button_test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Gọi findViewById từ view được inflate trong fragment

button_test = view.findViewById(R.id.button_test);

        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi Button được click
                showToast();
            }
        });
        // Bây giờ bạn có thể sử dụng text_test bình thường

        return view;
    }
    private void showToast() {
        Toast.makeText(getActivity(), "Button Clicked!", Toast.LENGTH_SHORT).show();
    }
}