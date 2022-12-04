package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.veggieempiregr5.databinding.ActivityMenuDetailBinding;

public class MenuDetailActivity extends AppCompatActivity {

    ActivityMenuDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_detail);
        binding = ActivityMenuDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        binding.imvDishesDetail.setImageResource(bundle.getInt("imagedetail"));
        binding.txtNameDetail.setText(bundle.getString("namedetail"));
        binding.txtPriceDetail.setText(String.valueOf(bundle.getDouble("pricedetail")));

    }
}