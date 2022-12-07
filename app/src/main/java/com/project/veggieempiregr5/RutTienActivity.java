package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.adapters.BankConnectedRutAdapter;
import com.project.adapters.RutTienAdapter;
import com.project.database.BankDatabaseHelper;
import com.project.veggieempiregr5.databinding.ActivityRutTienBinding;

import java.util.ArrayList;

public class RutTienActivity extends AppCompatActivity {

    ActivityRutTienBinding binding;

    RecyclerView recyclerView;
    ImageView imvLienKet;

    BankDatabaseHelper myDB;
    ArrayList<String> iD, bankName;
    BankConnectedRutAdapter bankAdapter;

    TextView txtChooseBank;
    String bankname;

    EditText edtTienRut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nap_tien);

        binding = ActivityRutTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Rút tiền về tài khoản");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        addEvents();

        recyclerView = findViewById(R.id.rcv_BankConnectedRutList);
        myDB = new BankDatabaseHelper(RutTienActivity.this);
        iD = new ArrayList<>();
        bankName = new ArrayList<>();


        storeDataInArray();

        bankAdapter = new BankConnectedRutAdapter(RutTienActivity.this, bankName);
        recyclerView.setAdapter(bankAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RutTienActivity.this));


        txtChooseBank = findViewById(R.id.txt_NguonTienRut);
        edtTienRut = findViewById(R.id.edt_RutTien);

        getIntentData();
    }

    private void getIntentData() {
        if (getIntent().hasExtra("bankname")){
            bankname = getIntent().getStringExtra("bankname");

            txtChooseBank.setText(bankname);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void storeDataInArray() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                iD.add(cursor.getString(0));
                bankName.add(cursor.getString(1));
            }
        }
    }

    private void addEvents() {
        binding.imvLienKet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RutTienActivity.this, LienKetActivity.class);
                startActivity(intent);
            }
        });

        binding.btn100K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtRutTien.setText("100000");
            }
        });

        binding.btn200K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtRutTien.setText("200000");
            }
        });

        binding.btn500K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtRutTien.setText("500000");
            }
        });

        binding.btnRutTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer soTienRut = Integer.valueOf(edtTienRut.getText().toString().trim()) ;
                BankUtil.soTienRut = soTienRut;

                String tenNH = txtChooseBank.getText().toString().trim();
                BankUtil.tenNHRut = tenNH;

                Intent intent = new Intent(RutTienActivity.this, XacNhanRutTienActivity.class);
                startActivity(intent);
            }
        });
    }
}