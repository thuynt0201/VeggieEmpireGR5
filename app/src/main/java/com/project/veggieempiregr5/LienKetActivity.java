package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.database.BankDatabaseHelper;
import com.project.models.Bank;
import com.project.veggieempiregr5.databinding.ActivityLienKetBinding;

public class LienKetActivity extends AppCompatActivity {

    //Phan nay cua nguyen

    ActivityLienKetBinding binding;
    EditText edtBankNumber, edtBankHolder, edtBankHolderId;
    TextView txtBankName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lien_ket);

        getSupportActionBar().setTitle("Liên kết ngân hàng");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        binding = ActivityLienKetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }

        Bank bank = (Bank) bundle.get("bank_name");
        txtBankName = findViewById(R.id.txt_ChooseBank);
        txtBankName.setText(bank.getBankName());

        edtBankNumber = findViewById(R.id.edt_bankNumber);
        edtBankHolder = findViewById(R.id.edt_bankHolder);
        edtBankHolderId = findViewById(R.id.edt_bankHolderId);
    }

    private void addEvents() {
        binding.imvSoThe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(LienKetActivity.this);
                dialog.setContentView(R.layout.dialog_sothe);
                dialog.setCanceledOnTouchOutside(false);

                ImageView imvCancel = dialog.findViewById(R.id.imv_Cancel);
                imvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        binding.imvChuThe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(LienKetActivity.this);
                dialog.setContentView(R.layout.dialog_chuthe);
                dialog.setCanceledOnTouchOutside(false);

                ImageView imvCancel = dialog.findViewById(R.id.imv_Cancel);
                imvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        binding.imvDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LienKetActivity.this, BankListActivity.class);
                startActivity(intent);
            }
        });

//        binding.imvBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(NhapThongTin.this, LienKet.class);
//                startActivity(intent);
//            }
//        });


        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BankDatabaseHelper myDB = new BankDatabaseHelper(LienKetActivity.this);
                myDB.addBankList(txtBankName.getText().toString().trim(),
                        Integer.valueOf(edtBankNumber.getText().toString().trim()),
                        edtBankHolder.getText().toString().trim(),
                        Integer.valueOf(edtBankHolderId.getText().toString().trim()));

                Intent intent1 = new Intent(LienKetActivity.this, NhapOTPActivity.class);
                startActivity(intent1);
            }
        });


    }
}