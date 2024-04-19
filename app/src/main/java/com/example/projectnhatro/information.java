package com.example.projectnhatro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class information extends AppCompatActivity {

    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        String titleMes = "Quản lý phòng trọ";
        TextView title = findViewById(R.id.txt_title);
        title.setText(titleMes);

        String nameText = "Họ và tên sinh viên:\t Nguyễn Minh Ân";
        TextView texName = findViewById(R.id.txt_nameStudent);
        texName.setText(nameText);

        String nameTeach = "GVHD:\t \t Th.s Trần Bá Minh Sơn";
        TextView texTeacher = findViewById(R.id.nameTeacher);
        texTeacher.setText(nameTeach);

        String idStudent = "MSSV: \t \t 2024801040013";
        TextView _idStudent = findViewById(R.id.idStudent);
        _idStudent.setText(idStudent);

        String monhoc = "Môn học: PHÁT TRIỂN XÂY DỰNG ỨNG DỤNG ANDROID";
        TextView _monhoc = findViewById(R.id.monhoc);
        _monhoc.setText(monhoc);

        String version = "version: 1.0";
        TextView _version = findViewById(R.id.version);
        _version.setText(version);

    }
}