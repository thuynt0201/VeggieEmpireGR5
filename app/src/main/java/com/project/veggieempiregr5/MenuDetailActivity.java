package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityMenuDetailBinding;

public class MenuDetailActivity extends AppCompatActivity {

    ActivityMenuDetailBinding binding;

    int numberOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_detail);
        binding = ActivityMenuDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Tùy chỉnh món ăn");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
        getData();
        addEvent();
    }

    private void addEvent() {

        binding.imgbtnMinustocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1){
                    numberOrder = numberOrder-1;
                    binding.txtNumberDetail.setText(String.valueOf(numberOrder));
                }
            }
        });

        binding.imgbtnPlustocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder+1;
                binding.txtNumberDetail.setText(String.valueOf(numberOrder));
            }
        });
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        binding.imvDishesDetail.setImageResource(bundle.getInt("imagedetail"));
        binding.txtNameDetail.setText(bundle.getString("namedetail"));
        binding.txtPriceDetail.setText(String.valueOf(bundle.getDouble("pricedetail")));

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menudetail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}