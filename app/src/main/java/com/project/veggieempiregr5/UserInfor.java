package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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