package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.database.DatabaseCart;
import com.project.database.DatabasePaymentOrder;
import com.project.veggieempiregr5.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    public static DatabasePaymentOrder databasePaymentOrder;
    ActivityPaymentBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment);

        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Thanh toán bằng ví VeggiePay");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======  //======THANH HEADER======

        addEvent();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        binding.txtTotalPayment.setText(bundle.getString("totalorder", ""));
    }

    private void addEvent() {

        binding.btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentDiaglop(Gravity.CENTER);
            }
        });
    }

    private void openPaymentDiaglop(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_payment);
        Window window = dialog.getWindow();
        if(window == null){            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        if (Gravity.CENTER == gravity){
            dialog.setCancelable(true);
        } else dialog.setCancelable(false);

        EditText edtPayment = dialog.findViewById(R.id.edt_InputOTP);
        Button btnHuy = dialog.findViewById(R.id.btn_Huythanhtoan);
        Button btnXacnhan = dialog.findViewById(R.id.btn_Xacnhan);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    dialog.dismiss();
            }
        });

        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

                //Lưu thanh toán đơn hàng vào database để push qua lịch sử giao dịch bên Ví
                DatabasePaymentOrder myDB = new DatabasePaymentOrder(PaymentActivity.this);
                myDB.addCart(binding.txtTotalPayment.getText().toString().trim());
                Toast.makeText(PaymentActivity.this,"Thanh toán thành công", Toast.LENGTH_SHORT).show();

                //Intent tổng tiền đơn hàng qua màn hình kết quả giao dịch
                Intent intent = new Intent (PaymentActivity.this,ResultPaymentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("totalgiaodich",((binding.txtTotalPayment.getText().toString().trim())));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        dialog.show();



    }


}