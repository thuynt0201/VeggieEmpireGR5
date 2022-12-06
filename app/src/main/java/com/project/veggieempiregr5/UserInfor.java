package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityTrangChuBinding;
import com.project.veggieempiregr5.databinding.ActivityUserInforBinding;

public class UserInfor extends AppCompatActivity {

    ActivityUserInforBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user_infor);

        binding = ActivityUserInforBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
        //======THANH HEADER======
        getSupportActionBar().setTitle("Tài khoản");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
    }

    private void addEvents() {
        binding.txtWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, Wallet.class);
                startActivity(intent2);
            }
        });
    }
}