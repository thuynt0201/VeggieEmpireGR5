package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ChiTietThanhToanActivity extends AppCompatActivity {

    TextView txtChiTietTienThanhToan;
    String chitiettienthanhtoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thanh_toan);

        getSupportActionBar().setTitle("Chi tiết giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        txtChiTietTienThanhToan = findViewById(R.id.txt_ChiTietTienThanhToan);

        GetAndSetIntentData();

    }

    private void GetAndSetIntentData() {
        if (getIntent().hasExtra("chitiettienthanhtoan")){
            chitiettienthanhtoan = getIntent().getStringExtra("chitiettienthanhtoan");

            txtChiTietTienThanhToan.setText("- " + chitiettienthanhtoan);
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}