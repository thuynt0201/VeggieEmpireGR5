package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityResultPaymentBinding;

public class ResultPaymentActivity extends AppCompatActivity {

    ActivityResultPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_result_payment);

        binding = ActivityResultPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Kết quả thanh toán");
        //======THANH HEADER END======  //======THANH HEADER======

        addEvent();
        getDataTienmat();
        getDataVi();
    }

    private void getDataVi() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        binding.txtTotalGiaodich.setText(bundle.getString("totalgiaodich", ""));
    }

    private void getDataTienmat() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        binding.txtTotalGiaodich.setText(bundle.getString("totalorder", ""));
    }

    private void addEvent() {
        binding.btnSeeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ResultPaymentActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_resultpayment_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mn_Hompage){
            Intent intent = new Intent (ResultPaymentActivity.this,TrangChu.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}