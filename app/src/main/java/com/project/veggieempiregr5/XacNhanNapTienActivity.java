package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.project.models.Bank;
import com.project.models.BankConnected;

public class XacNhanNapTienActivity extends AppCompatActivity {

    TextView txtNguonTienNap, txtSoTienNap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_nap_tien);

        txtNguonTienNap = findViewById(R.id.txt_NguonTienNap);
        txtSoTienNap = findViewById(R.id.txt_SoTienNap);

        txtSoTienNap.setText(BankUtil.soTienNap.toString());
        txtNguonTienNap.setText(BankUtil.tenNH);
    }
}