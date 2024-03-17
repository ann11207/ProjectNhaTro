package com.example.projectnhatro.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectnhatro.DBHelper;
import com.example.projectnhatro.DashBoard;
import com.example.projectnhatro.R;
import com.example.projectnhatro.Register;
import com.example.projectnhatro.userDB;


public class AccountFragment extends Fragment {

    CheckBox checkBox_ShowPass;
    EditText editText_Pass, editText_userName;

    TextView textView_Register;

    Button btn_Login;

    userDB userDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Initialize userDB
        userDB = userDB.getInstance(getActivity());


        // Reference CheckBox and EditText
        checkBox_ShowPass = view.findViewById(R.id.checkbox_ShowPassWord);
        editText_userName = view.findViewById(R.id.edtLogin_UserName);
        editText_Pass = view.findViewById(R.id.edtLogin_PassWord);

        // click intent switch to register
        textView_Register = view.findViewById(R.id.txtLogin_Register);
        textView_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });

        // Checkbox show password
        checkBox_ShowPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editText_Pass.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    editText_Pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

        // Login button click listener
        btn_Login = view.findViewById(R.id.btnLogin_Login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText_userName.getText().toString();
                String pass = editText_Pass.getText().toString();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getActivity(), "Điền thông tin vào ô trống!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = userDB.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(getActivity(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intentSucessLogin = new Intent(getActivity(), DashBoard.class);
                        startActivity(intentSucessLogin);
                    } else {
                        Toast.makeText(getActivity(), "Sai thông tin", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        return view;

    }
}
