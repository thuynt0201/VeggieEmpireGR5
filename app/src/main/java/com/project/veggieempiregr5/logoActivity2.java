package com.project.veggieempiregr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.project.veggieempiregr5.databinding.ActivityLogo2Binding;
import com.project.veggieempiregr5.databinding.ActivityLogo2Binding;

public class logoActivity2 extends AppCompatActivity {
    ActivityLogo2Binding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_logo2);

        getSupportActionBar().setTitle("VEGGIE EMPIRE");

        binding = ActivityLogo2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        add();


    }
    private void add() {

        binding.imvlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(logoActivity2.this,loginvaoActivity2.class);
                startActivity(intent);
            }
        });

    }
}