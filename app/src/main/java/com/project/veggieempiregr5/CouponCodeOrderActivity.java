package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityCartBinding;
import com.project.veggieempiregr5.databinding.ActivityCouponCodeOrderBinding;

public class CouponCodeOrderActivity extends AppCompatActivity {

    ActivityCouponCodeOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_code_order);
        binding = ActivityCouponCodeOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Mã khuyến mãi");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

        intentData();

    }

    private void intentData() {
        binding.coupon30k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (CouponCodeOrderActivity.this,CartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("coupon",30000);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        binding.coupon40k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (CouponCodeOrderActivity.this,CartActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("coupon",40000);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        binding.coupon50k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (CouponCodeOrderActivity.this,CartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("coupon",50000);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_coupon_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mn_Hompage){

            Intent intent = new Intent (CouponCodeOrderActivity.this,TrangChu.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.mn_Menu){

            Intent intent = new Intent (CouponCodeOrderActivity.this,MenuActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}