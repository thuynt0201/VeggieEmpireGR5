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

import com.project.adapters.BankConnectedAdapter;
import com.project.database.BankDatabaseHelper;
import com.project.models.Bank;
import com.project.models.BankConnected;
import com.project.veggieempiregr5.databinding.ActivityNapTienBinding;

import java.util.ArrayList;

public class NapTienActivity extends AppCompatActivity {

    ActivityNapTienBinding binding;

    RecyclerView recyclerView;
    ImageView imvLienKet;

    BankDatabaseHelper myDB;
    ArrayList<String> iD, bankName;
    BankConnectedAdapter bankAdapter;

    TextView txtChooseBank;
    String bankname;

    EditText edtTienNap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nap_tien);

        binding = ActivityNapTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Nạp tiền vào ví");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        addEvents();

        recyclerView = findViewById(R.id.rcv_BankConnectdList);
        myDB = new BankDatabaseHelper(NapTienActivity.this);
        iD = new ArrayList<>();
        bankName = new ArrayList<>();


        storeDataInArray();

        bankAdapter = new BankConnectedAdapter(NapTienActivity.this, bankName);
        recyclerView.setAdapter(bankAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(NapTienActivity.this));

        
        txtChooseBank = findViewById(R.id.txt_NguonTien);
        edtTienNap = findViewById(R.id.edt_NhapTien);

        getIntentData();

    }

    void getIntentData(){
        if (getIntent().hasExtra("bankname")){
            bankname = getIntent().getStringExtra("bankname");

            txtChooseBank.setText(bankname);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void storeDataInArray(){
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
                Intent intent = new Intent(NapTienActivity.this, LienKetActivity.class);
                startActivity(intent);
            }
        });

        binding.btn100K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtNhapTien.setText("100000");
            }
        });

        binding.btn200K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtNhapTien.setText("200000");
            }
        });

        binding.btn500k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edtNhapTien.setText("500000");
            }
        });

        binding.btnNapTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer soTienNap = Integer.valueOf(edtTienNap.getText().toString().trim()) ;
                BankUtil.soTienNap = soTienNap;

                String tenNH = txtChooseBank.getText().toString().trim();
                BankUtil.tenNH = tenNH;

                Intent intent = new Intent(NapTienActivity.this, XacNhanNapTienActivity.class);
                startActivity(intent);
            }
        });
    }
}