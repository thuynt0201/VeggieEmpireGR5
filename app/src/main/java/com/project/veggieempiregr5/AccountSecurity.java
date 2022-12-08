package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityAccountSecurityBinding;
import com.project.veggieempiregr5.databinding.ActivityHelpCenterBinding;

public class AccountSecurity extends AppCompatActivity {

    ActivityAccountSecurityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_account_security);

        binding = ActivityAccountSecurityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Tài khoản & Bảo mật");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

        addEvent();
    }

    private void addEvent() {
        binding.btnEditthongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AccountSecurity.this,EditInfAcountActivity.class);
                startActivity(intent);
            }
        });
    }
}