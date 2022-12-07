package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ChiTietRutActivity extends AppCompatActivity {

    TextView txtChiTietTienRut, txtChiTietNguonRut;
    String chitiettienrut, chitietnguontienrut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_rut);

        getSupportActionBar().setTitle("Chi tiết giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        txtChiTietTienRut = findViewById(R.id.txt_ChiTietTienRut);
        txtChiTietNguonRut = findViewById(R.id.txt_ChiTietNguonTienRut);

        GetAndSetIntentData();

    }

    private void GetAndSetIntentData() {
        if (getIntent().hasExtra("chitietnguontienrut") && getIntent().hasExtra("chitiettienrut")){
            chitietnguontienrut = getIntent().getStringExtra("chitietnguontienrut");
            chitiettienrut = getIntent().getStringExtra("chitiettienrut");

            txtChiTietNguonRut.setText(chitietnguontienrut);
            txtChiTietTienRut.setText("-" + chitiettienrut);

        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}