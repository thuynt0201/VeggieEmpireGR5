package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ChiTietNapActivity extends AppCompatActivity {

    TextView txtChiTietTienNap, txtChiTietNguonNap;
    String chitiettiennap, chitietnguontien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nap);

        getSupportActionBar().setTitle("Chi tiết giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        txtChiTietTienNap = findViewById(R.id.txt_ChiTietTienNap);
        txtChiTietNguonNap = findViewById(R.id.txt_ChiTietNguonTien);

        GetAndSetIntentData();
    }

    void GetAndSetIntentData(){
        if (getIntent().hasExtra("chitietnguontien") && getIntent().hasExtra("chitiettiennap")){
            chitietnguontien = getIntent().getStringExtra("chitietnguontien");
            chitiettiennap = getIntent().getStringExtra("chitiettiennap");

            txtChiTietNguonNap.setText(chitietnguontien);
            txtChiTietTienNap.setText("+ " + chitiettiennap);

        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}