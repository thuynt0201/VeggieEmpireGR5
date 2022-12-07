package com.project.veggieempiregr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.project.veggieempiregr5.databinding.ActivityLoginvao2Binding;


public class loginvaoActivity2 extends AppCompatActivity {
ActivityLoginvao2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_loginvao2);

        binding = ActivityLoginvao2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();

    }

    private void addEvent() {
        binding.btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginvaoActivity2.this,loginActivity2.class);
                startActivity(intent);
            }
        });
        binding.btnkvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           }
        });
    }
}