package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.project.models.Bank;
import com.project.models.BankConnected;

public class XacNhanNapTienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_nap_tien);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }

        BankConnected bank = (BankConnected) bundle.get("banklist_name");
        TextView txtBankName = findViewById(R.id.txt_NguonTienNap);
        txtBankName.setText(bank.getBankName());

        TextView txtTienNap = findViewById(R.id.txt_SoTienNap);
        txtBankName.setText(bank.getBankTienNap().toString());

        TextView txtSoDu = findViewById(R.id.txt_SoDuVi);
        txtBankName.setText(bank.getBankSoDu().toString());

    }
}