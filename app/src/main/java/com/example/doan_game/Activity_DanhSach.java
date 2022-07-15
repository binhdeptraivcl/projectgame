package com.example.doan_game;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.app.Application;

import java.util.ArrayList;

public class Activity_DanhSach extends AppCompatActivity {
    Database database;
    ListView lvDanhSach;
    ArrayList<DanhSach> arrayDanhSach;
    DanhSachAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);

        database = new Database(this, "DOAN.sqlite", null, 1);
        lvDanhSach = (ListView)findViewById(R.id.listviewDanhSach);
        arrayDanhSach = new ArrayList<>();
        adapter = new DanhSachAdapter(this, R.layout.dong_danh_sach, arrayDanhSach);
        GetDataDanhSach();
        lvDanhSach.setAdapter(adapter);


    }

    private void GetDataDanhSach(){
        //select data
        Cursor dataDanhSach= database.GetData("SELECT * FROM Danhsach");
        arrayDanhSach.clear();
        while (dataDanhSach.moveToNext()){
            int id = dataDanhSach.getInt(0);
            String ten = dataDanhSach.getString(1);
            String diem = dataDanhSach.getString(2);
            arrayDanhSach.add(new DanhSach(id, ten, diem));
        }
        adapter.notifyDataSetChanged();
    }
}