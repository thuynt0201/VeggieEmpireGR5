package com.project.veggieempiregr5;

import static com.project.veggieempiregr5.R.id.btn_NapList;
import static com.project.veggieempiregr5.R.id.btn_RutList;
import static com.project.veggieempiregr5.R.id.rcv_NapList;

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

import com.project.adapters.NapTienAdapter;
import com.project.database.NapTienDatabase;
import com.project.veggieempiregr5.databinding.ActivityLichSuNapBinding;
import com.project.veggieempiregr5.databinding.ActivityLienKetBinding;

import java.util.ArrayList;

public class LichSuNapActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn_nap, btn_rut;

    NapTienDatabase napTienDatabase;
    ArrayList<String> id, sotiennap, nguontien;

    NapTienAdapter napTienAdapter;

    ActivityLichSuNapBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lich_su_nap);
        binding = ActivityLichSuNapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Chi tiết giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        recyclerView = findViewById(R.id.rcv_NapList);

        addEvents();


        napTienDatabase = new NapTienDatabase(LichSuNapActivity.this);
        id = new ArrayList<>();
        sotiennap = new ArrayList<>();
        nguontien = new ArrayList<>();

        displayData();

        napTienAdapter = new NapTienAdapter(LichSuNapActivity.this, id, sotiennap, nguontien);
        recyclerView.setAdapter(napTienAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LichSuNapActivity.this));

    }

    private void addEvents() {
        binding.btnRutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuNapActivity.this, LichSuRutActivity.class);
                startActivity(intent);
            }
        });
        binding.btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuNapActivity.this, LichSuThanhToanActivity.class);
                startActivity(intent);
            }
        });
    }

    void displayData(){
        Cursor cursor = napTienDatabase.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                sotiennap.add(cursor.getString(1));
                nguontien.add(cursor.getString(2));

            }
        }
    }
}