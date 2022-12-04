package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityNapTienBinding;

public class NapTienActivity extends AppCompatActivity {

    ActivityNapTienBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nap_tien);

        binding = ActivityNapTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Nạp tiền vào ví");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        addEvents();
    }

    private void addEvents() {
        binding.btnLienKet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NapTienActivity.this, LienKetActivity.class);
                startActivity(intent);
            }
        });

        binding.btn200K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtNhapTien.setText("200000");
            }
        });

        binding.btn500K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtNhapTien.setText("500000");
            }
        });

        binding.btn1Tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtNhapTien.setText("1000000");
            }
        });
    }
}