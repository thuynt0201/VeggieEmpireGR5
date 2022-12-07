package com.project.veggieempiregr5;

import static com.project.veggieempiregr5.R.id.btn_NapList;
import static com.project.veggieempiregr5.R.id.btn_RutList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.adapters.RutTienAdapter;
import com.project.database.RutTienDatabase;
import com.project.veggieempiregr5.databinding.ActivityLichSuRutBinding;
import com.project.veggieempiregr5.databinding.ActivityTrangChuBinding;

import java.util.ArrayList;

public class LichSuRutActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    RutTienDatabase rutTienDatabase;
    ArrayList<String> id, sotienrut, nguontienrut;

    RutTienAdapter rutTienAdapter;

    ActivityLichSuRutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_trang_chu);
        binding = ActivityLichSuRutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Chi tiết giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        recyclerView = findViewById(R.id.rcv_RutList);

        addEvents();

        rutTienDatabase = new RutTienDatabase(LichSuRutActivity.this);
        id = new ArrayList<>();
        sotienrut = new ArrayList<>();
        nguontienrut = new ArrayList<>();

        displayData();

        rutTienAdapter = new RutTienAdapter(LichSuRutActivity.this, id, sotienrut, nguontienrut);
        recyclerView.setAdapter(rutTienAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LichSuRutActivity.this));

    }

    private void addEvents() {
        binding.btnNapList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuRutActivity.this, LichSuNapActivity.class);
                startActivity(intent);
            }
        });

        binding.btnTatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuRutActivity.this, LichSuGDActivity.class);
                startActivity(intent);
            }
        });
    }

    void displayData(){
        Cursor cursor = rutTienDatabase.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                sotienrut.add(cursor.getString(1));
                nguontienrut.add(cursor.getString(2));

            }
        }
    }
}