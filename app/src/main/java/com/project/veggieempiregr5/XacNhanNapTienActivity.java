package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.database.NapTienDatabase;
import com.project.veggieempiregr5.databinding.ActivityXacNhanNapTienBinding;

public class XacNhanNapTienActivity extends AppCompatActivity {

    ActivityXacNhanNapTienBinding binding;
    TextView txtNguonTienNap, txtSoTienNap;

    String txtLoaiGiaoDich = "Nạp tiền";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xac_nhan_nap_tien);

        binding = ActivityXacNhanNapTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Nạp tiền vào ví");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        txtNguonTienNap = findViewById(R.id.txt_NguonTienNap);
        txtSoTienNap = findViewById(R.id.txt_SoTienNap);

        txtSoTienNap.setText(BankUtil.soTienNap.toString());
        txtNguonTienNap.setText(BankUtil.tenNH);

        addEvents();
    }

    private void addEvents() {

        binding.btnXacNhanNap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(XacNhanNapTienActivity.this);
                dialog.setContentView(R.layout.dialog_otp_xacnhannap);
                dialog.setCanceledOnTouchOutside(false);

                Button btnOTPXacNhan = dialog.findViewById(R.id.btn_NhapOTPXacNhan);
                btnOTPXacNhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NapTienDatabase napTienDatabase = new NapTienDatabase(XacNhanNapTienActivity.this);
                        napTienDatabase.addNapTienList(txtNguonTienNap.getText().toString().trim(),
                                Integer.valueOf(txtSoTienNap.getText().toString().trim()));

                        Intent intent = new Intent(XacNhanNapTienActivity.this, KetQuaGD.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        });
    }
}