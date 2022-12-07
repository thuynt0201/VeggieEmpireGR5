package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.project.adapters.VoucherAdapter;
import com.project.database.SQLiteHelper;
import com.project.models.Voucher;

public class VoucherActivity extends AppCompatActivity implements VoucherAdapter.OnItemClick {
    private SQLiteHelper db;
    private RecyclerView rcvVoucher;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai);
        db = new SQLiteHelper(this);

        //custom toolbar
        //List ticket
        rcvVoucher=findViewById(R.id.rcv_voucher);
        //dsticket = new ArrayList<>();
        VoucherAdapter adapter = new VoucherAdapter(db.getVoucherAll());
        rcvVoucher.setLayoutManager(new LinearLayoutManager(this));
        rcvVoucher.setAdapter(adapter);
        adapter.setOnItemClick(this);
        //List ticket



    }

    @Override
    public void onItemClick(Voucher data) {
        startActivity(new Intent(VoucherActivity.this,MenuActivity.class));
        finish();
    }
}
