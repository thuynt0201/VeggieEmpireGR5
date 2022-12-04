package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityNhapOtpBinding;

public class NhapOTPActivity extends AppCompatActivity {

    ActivityNhapOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nhap_otp);

        getSupportActionBar().setTitle("Nhập mã xác thực OTP");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        binding = ActivityNhapOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        addEvents();
        
    }

    private void addEvents() {
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NhapOTPActivity.this, ConnectSuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}