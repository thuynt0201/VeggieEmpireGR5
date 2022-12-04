package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityConnectSuccessBinding;

public class ConnectSuccessActivity extends AppCompatActivity {

    ActivityConnectSuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_connect_success);

        getSupportActionBar().setTitle(" ");


        binding = ActivityConnectSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        addEvents();
    }

    private void addEvents() {
        binding.btnNap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectSuccessActivity.this, NapTienActivity.class);
                startActivity(intent);
            }
        });

        binding.btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectSuccessActivity.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }
}