package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityOrderCanceledBinding;
import com.project.veggieempiregr5.databinding.ActivityOrderDeliveredBinding;

public class OrderCanceledActivity extends AppCompatActivity {

    ActivityOrderCanceledBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_canceled);
        binding = ActivityOrderCanceledBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Chi tiết đơn hàng");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
        addEvent();
    }

    private void addEvent() {
        binding.btnOrderAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderCanceledActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}