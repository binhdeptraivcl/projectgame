package com.example.doan_game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Acivity_Game extends AppCompatActivity {
    Database database;
    ArrayList<DanhSach> arrayDanhSach;
    DanhSachAdapter adapter;
    TextView txtDiem;
    ImageButton ibtnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    Button btnOut;
    int sodiem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_game);

        database = new Database(this, "DOAN.sqlite", null, 1);
        arrayDanhSach = new ArrayList<>();
        adapter = new DanhSachAdapter(this, R.layout.dong_danh_sach, arrayDanhSach);
        GetDataDanhSach();
        Anhxa();

        Intent intent = this.getIntent();
        long ID = intent.getLongExtra("id", 123);

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(sodiem + "");

        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 6;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                // kiểm tra
                if(skOne.getProgress() >= skOne.getMax())
                {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(Acivity_Game.this, "Vịt Win!!!", Toast.LENGTH_SHORT).show();
                    if(cbOne.isChecked())
                    {
                        sodiem += 10;
                        Toast.makeText(Acivity_Game.this, "Bạn đoán đúng rồiii!", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        sodiem -= 5;
                        if(sodiem < 0)
                            sodiem = 0;
                        Toast.makeText(Acivity_Game.this, "Rất tiếc! sai mất òyyy", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    Edit(ID);
                    EnableCheckBox();
                }
                if(skTwo.getProgress() >= skTwo.getMax())
                {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(Acivity_Game.this, "Khủng long Win!!!", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked())
                    {
                        sodiem += 10;
                        Toast.makeText(Acivity_Game.this, "Bạn đoán đúng rồiii!", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        sodiem -= 5;
                        if(sodiem < 0)
                            sodiem = 0;
                        Toast.makeText(Acivity_Game.this, "Rất tiếc! sai mất òyyy", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    Edit(ID);
                    EnableCheckBox();
                }
                if(skThree.getProgress() >= skThree.getMax())
                {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(Acivity_Game.this, "Rùa Win!!!", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked())
                    {
                        sodiem += 10;
                        Toast.makeText(Acivity_Game.this, "Bạn đoán đúng rồiii!", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        sodiem -= 5;
                        if(sodiem < 0)
                            sodiem = 0;
                        Toast.makeText(Acivity_Game.this, "Rất tiếc! sai mất òyyy", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    Edit(ID);
                    EnableCheckBox();
                }

                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked())
                {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBos();
                }else {
                    Toast.makeText(Acivity_Game.this, "Vui lòng đặt cược!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thoat = new Intent(Acivity_Game.this, MainActivity.class);
                startActivity(thoat);
            }
        });
        // checkbox 1
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    // bỏ check 2 3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        // checkbox 2
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    // bỏ check 1 3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        // checkbox 3
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    // bỏ check 2 3
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }
    private void EnableCheckBox()
    {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }
    private void DisableCheckBos()
    {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);

    }
    private void Anhxa()
    {
        txtDiem = (TextView) findViewById(R.id.textViewDiemSo);
        ibtnPlay = (ImageButton)findViewById(R.id.buttonPlay);
        cbOne = (CheckBox) findViewById(R.id.checkBoxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkBoxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkBoxThree);
        skOne = (SeekBar) findViewById(R.id.seekBarOne);
        skTwo = (SeekBar) findViewById(R.id.seekBarTwo);
        skThree = (SeekBar) findViewById(R.id.seekBarThree);
        btnOut = (Button) findViewById(R.id.buttonThoat);
    }

    public void Edit(long id){

        String diemmoi = sodiem + "";
        database.QueryData("UPDATE Danhsach SET Diem = '"+diemmoi+"' WHERE Id = '"+id+"' ");
        GetDataDanhSach();
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