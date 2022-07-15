package com.example.doan_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    EditText edtTen;
    Button btnGame, btnDiemCao;
    ListView lvdanhsach;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

//        tạo database
        database = new Database(this, "DOAN.sqlite", null, 1);

//        tạo bảng student
        database.QueryData("CREATE TABLE IF NOT EXISTS Danhsach(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(200), Diem VARCHAR(200))");

        Start();
        DiemCao();
    }

    private void AnhXa(){
        edtTen = (EditText) findViewById(R.id.edittextUser);
        btnGame = (Button) findViewById(R.id.buttonGame);
        btnDiemCao = (Button) findViewById(R.id.buttonDanhSach);
    }

    private void Start(){

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tenuser = edtTen.getText().toString();
                if(tenuser.equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
                }else {
                    ContentValues values = new ContentValues();
                    values.put("ten",tenuser);
                    values.put("diem","0");
//                    database.QueryData("INSERT INTO Danhsach VALUES(null, '"+tenuser+"', 'chuaco')");
                    long id = database.getWritableDatabase().insert("Danhsach", null, values    );
                    System.out.println(id);
                    Intent intentGame = new Intent(MainActivity.this, Acivity_Game.class);

                    intentGame.putExtra("id", id);

                    startActivity(intentGame);
                }
                edtTen.setText("");
            }
        });
    }
    private void DiemCao(){
        btnDiemCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_DanhSach.class);
                startActivity(intent);
            }
        });
    }

}