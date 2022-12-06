package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class KetQuaGD extends AppCompatActivity {

    TextView txtNapSuccess1, txtNapSuccess2;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua_gd);

        getSupportActionBar().setTitle("Kết quả giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_home_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        txtNapSuccess1 = findViewById(R.id.txt_NapSuccess1);
        txtNapSuccess2 = findViewById(R.id.txt_NapSuccess2);

        txtNapSuccess1.setText(BankUtil.soTienNap.toString());
        txtNapSuccess2.setText("Bạn đã nạp thành công " + BankUtil.soTienNap.toString() + " vào ví VeggiePay bằng tài khoản ngân hànng");

    }
}