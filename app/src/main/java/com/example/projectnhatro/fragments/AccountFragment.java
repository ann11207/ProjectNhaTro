package com.example.projectnhatro.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectnhatro.DashBoard;
import com.example.projectnhatro.R;


public class AccountFragment extends Fragment {

    CheckBox checkBox_ShowPass;
    EditText editText_Pass;

    TextView textView_Register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);



        // reference CheckBox and EditText
        checkBox_ShowPass = view.findViewById(R.id.checkbox_ShowPassWord);
        editText_Pass = view.findViewById(R.id.EditText_PassWord);

        // click intent switch to register
        TextView textView_Register = view.findViewById(R.id.textView_Register);

        textView_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DashBoard.class);
                startActivity(intent);
            }
        });
        //checkbox show password
        checkBox_ShowPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    editText_Pass.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else {
                    editText_Pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        return view;


    }
}