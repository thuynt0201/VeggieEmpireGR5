package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityLichSuGdactivityBinding;

public class LichSuGDActivity extends AppCompatActivity {

    ActivityLichSuGdactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//setContentView(R.layout.activity_xac_nhan_nap_tien);

        binding = ActivityLichSuGdactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Lịch sử giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        addEvents();


    }


    private void addEvents() {
        binding.btnNap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuGDActivity.this, LichSuNapActivity.class);
                startActivity(intent);
            }
        });
        binding.btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuGDActivity.this, LichSuRutActivity.class);
                startActivity(intent);
            }
        });
        binding.btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuGDActivity.this, LichSuThanhToanActivity.class);
                startActivity(intent);
            }
        });
    }
}