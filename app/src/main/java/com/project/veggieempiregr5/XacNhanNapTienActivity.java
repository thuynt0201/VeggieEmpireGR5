package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.models.Bank;
import com.project.models.BankConnected;
import com.project.veggieempiregr5.databinding.ActivityWalletBinding;
import com.project.veggieempiregr5.databinding.ActivityXacNhanNapTienBinding;

public class XacNhanNapTienActivity extends AppCompatActivity {

    ActivityXacNhanNapTienBinding binding;
    TextView txtNguonTienNap, txtSoTienNap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_xac_nhan_nap_tien);

        binding = ActivityXacNhanNapTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

        txtNguonTienNap = findViewById(R.id.txt_NguonTienNap);
        txtSoTienNap = findViewById(R.id.txt_SoTienNap);

        txtSoTienNap.setText(BankUtil.soTienNap.toString());
        txtNguonTienNap.setText(BankUtil.tenNH);
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
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}