package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.installations.Utils;
import com.project.retrofit.ApiBanHang;
import com.project.retrofit.RetrofitClient;
import com.project.veggieempiregr5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}