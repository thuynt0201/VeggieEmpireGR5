package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.database.RutTienDatabase;
import com.project.veggieempiregr5.databinding.ActivityXacNhanRutTienBinding;

public class XacNhanRutTienActivity extends AppCompatActivity {

    ActivityXacNhanRutTienBinding binding;
    private  TextView txtNguonTienRut, txtSoTienRut;

    String txtLoaiGiaoDich = "Rút tiền";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xac_nhan_nap_tien);


        binding = ActivityXacNhanRutTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Nạp tiền vào ví");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        txtNguonTienRut = findViewById(R.id.txt_NguonTienRut);
        txtSoTienRut = findViewById(R.id.txt_SoTienRut);

        txtSoTienRut.setText(BankUtil.soTienRut.toString());
        txtNguonTienRut.setText(BankUtil.tenNHRut);

        addEvents();
    }

    private void addEvents() {
        binding.btnXacNhanRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(XacNhanRutTienActivity.this);
                dialog.setContentView(R.layout.dialog_otp_xacnhanrut);
                dialog.setCanceledOnTouchOutside(false);

                Button btnOTPXacNhan = dialog.findViewById(R.id.btn_NhapOTPXacNhanRut);
                btnOTPXacNhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RutTienDatabase rutTienDatabase = new RutTienDatabase(XacNhanRutTienActivity.this);
                        rutTienDatabase.addRutTienList(txtNguonTienRut.getText().toString().trim(),
                                Integer.valueOf(txtSoTienRut.getText().toString().trim()));

                        Intent intent = new Intent(XacNhanRutTienActivity.this, KetQuaRutActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        });
    }
}