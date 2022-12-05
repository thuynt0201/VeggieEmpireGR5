package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.project.adapters.OrderAdapter;
import com.project.models.Order;
import com.project.veggieempiregr5.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    OrderAdapter adapter;
    ArrayList<Order> orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_order);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Đơn hàng");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

        loadData();
        addEvent();

    }

    private void addEvent() {
        binding.lvDelivering.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Order order = (Order) adapter.getItem(i);
                if(order.getStatus().toString() == "Đang giao"){
                    Intent intent = new Intent (OrderActivity.this,OrderDeliveringActivity.class);
                    startActivity(intent);
                } else if(order.getStatus().toString() == "Đã giao"){
                    Intent intent = new Intent (OrderActivity.this,OrderDeliveredActivity.class);
                    startActivity(intent);
                } else if (order.getStatus().toString() == "Đã hủy"){
                    Intent intent = new Intent (OrderActivity.this,OrderCanceledActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadData() {
        orders = new ArrayList<>();

        orders.add(new Order(1, "Giao hàng tận nơi", "20 thg12 2022, 20:10","Ví Veggie Empire","Đang giao"));
        orders.add(new Order(1, "Giao hàng tận nơi", "11 thg11 2022, 19:02","Ví Veggie Empire","Đã giao"));
        orders.add(new Order(1, "Giao hàng tận nơi", "03 thg11 2022, 10:46","Tiền mặt","Đã giao"));
        orders.add(new Order(1, "Giao hàng tận nơi", "27 thg10 2022, 15:34","Ví Veggie Empire","Đã hủy"));
        orders.add(new Order(1, "Mua mang về", "05 thg09 2022, 11:22","Ví Veggie Empire","Đã giao"));
        orders.add(new Order(1, "Mua mang về", "27 thg08 2022, 15:34","Tiền mặt","Đã hủy"));
        orders.add(new Order(1, "Giao hàng tận nơi", "15 thg08 2022, 11:22","Ví Veggie Empire","Đã giao"));

        adapter = new OrderAdapter(OrderActivity.this, R.layout.item_order,orders);
        binding.lvDelivering.setAdapter(adapter);
    }
}