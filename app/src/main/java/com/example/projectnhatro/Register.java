package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectnhatro.R;
import com.example.projectnhatro.fragments.AccountFragment;

public class Register extends AppCompatActivity {

    EditText edt_userName , edt_passWord, edt_rePassWord;

    Button btn_Register;
    TextView txt_haveAccount;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //switch page login with textView
        txt_haveAccount =  findViewById(R.id.txtRegister_haveAccount);
        txt_haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSwitchPageLogin = new Intent(Register.this, AccountFragment.class);

                startActivity(intentSwitchPageLogin);
            }
        });

        edt_userName = findViewById(R.id.edtRegister_UserName);
        edt_passWord = findViewById(R.id.edtRegister_PassWord);
        edt_rePassWord = findViewById(R.id.edtRegister_RePassWord);

        DB = new DBHelper(this);

        btn_Register = findViewById(R.id.btnRegister_Register);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edt_userName.getText().toString();
                String pass = edt_passWord.getText().toString();
                String repass = edt_rePassWord.getText().toString();

                userDB userDB = new userDB(Register.this);

                if (user.equals("")|| pass.equals("")||repass.equals(""))
                    Toast.makeText(Register.this, "nhập thông tin", Toast.LENGTH_SHORT).show();
                else {

                    if (pass.equals(repass)){
                        Boolean checkuser =  userDB.chekusername(user);
                        if (checkuser == false){
                            Boolean insert = userDB.insertData(user,pass);
                            if (insert == true){
                                Toast.makeText(Register.this,"Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                                Intent intentSwitchLogin = new Intent(getApplicationContext(), AccountFragment.class);
                                startActivity(intentSwitchLogin);
                            }else {

                                Toast.makeText(Register.this,"Đăng ký không thành công!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        else{
                            Toast.makeText(Register.this,"Tên đăng nhập đã tồn tại ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "Mật khẩu không khớp !",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}