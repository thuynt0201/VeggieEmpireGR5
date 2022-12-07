package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.adapters.ThanhToanAdapter;
import com.project.database.DatabasePaymentOrder;
import com.project.veggieempiregr5.databinding.ActivityLichSuThanhToanBinding;

import java.util.ArrayList;

public class LichSuThanhToanActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    DatabasePaymentOrder databasePaymentOrder;
    ArrayList<String> id, sotienthanhtoan;

    ThanhToanAdapter thanhToanAdapter;

    ActivityLichSuThanhToanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_trang_chu);
        binding = ActivityLichSuThanhToanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Chi tiết giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        recyclerView = findViewById(R.id.rcv_ThanhToanList);

        addEvents();

        databasePaymentOrder = new DatabasePaymentOrder(LichSuThanhToanActivity.this);
        id = new ArrayList<>();
        sotienthanhtoan = new ArrayList<>();

        displayData();

        thanhToanAdapter = new ThanhToanAdapter(LichSuThanhToanActivity.this, id, sotienthanhtoan);
        recyclerView.setAdapter(thanhToanAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LichSuThanhToanActivity.this));
    }

    private void addEvents() {
        binding.btnNapList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuThanhToanActivity.this, LichSuNapActivity.class);
                startActivity(intent);
            }
        });

        binding.btnTatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuThanhToanActivity.this, LichSuGDActivity.class);
                startActivity(intent);
            }
        });
        binding.btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuThanhToanActivity.this, LichSuRutActivity.class);
                startActivity(intent);
            }
        });
    }
    private void displayData(){
        Cursor cursor = databasePaymentOrder.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                sotienthanhtoan.add(cursor.getString(1));
            }
        }
    }
}