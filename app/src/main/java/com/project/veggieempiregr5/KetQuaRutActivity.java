package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class KetQuaRutActivity extends AppCompatActivity {

    TextView txtRutSuccess1, txtRutSuccess2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua_rut);

        getSupportActionBar().setTitle("Kết quả giao dịch");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_home_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        txtRutSuccess1 = findViewById(R.id.txt_RutSuccess1);
        txtRutSuccess2 = findViewById(R.id.txt_RutSuccess2);

        txtRutSuccess1.setText(BankUtil.soTienRut.toString());
        txtRutSuccess2.setText("Bạn đã rút thành công " + BankUtil.soTienRut.toString() + " từ ví VeggiePay về tài khoản ngân hàng");
    }
}