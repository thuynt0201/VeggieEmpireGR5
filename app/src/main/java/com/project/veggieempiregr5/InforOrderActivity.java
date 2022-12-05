package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.project.veggieempiregr5.databinding.ActivityInforOrderBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InforOrderActivity extends AppCompatActivity {
    ActivityInforOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_infor_order);

        binding = ActivityInforOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Thông tin đơn hàng");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
        chooseDay();
        chooseTime();
        addEvents();
        getDataCart();
    }

    private void getDataCart() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int tong = 0;
        int giamGia = 0;
        int tongThanhToan = 0;
        if(bundle !=null)
        {
            tong = (bundle.getInt("totalallitemcart",0));
           giamGia = (bundle.getInt("discountcart",0));
        }
        tongThanhToan = tong +20000-giamGia;
        binding.txtTong.setText(String.valueOf(tong));
        binding.txtGiamgia.setText(String.valueOf(giamGia));
        binding.txtTongThanhToan.setText(String.valueOf(tongThanhToan)+"đ");
    }

    private void addEvents() {
        binding.radMuamangve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InforOrderActivity.this, "Bạn hãy chọn thời gian đến nhận", Toast.LENGTH_SHORT).show();
            }
        });





    }

    private void chooseTime() {
        Calendar calendarTime = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        binding.txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener callBack = new
                        TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                calendarTime.set(Calendar.HOUR, i);
                                calendarTime.set(Calendar.MINUTE, i1);
                                binding.txtTime.setText(timeFormat.format(calendarTime.getTime()));
                            }
                        };
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        InforOrderActivity.this,
                        callBack,
                        calendarTime.get(Calendar.HOUR),
                        calendarTime.get(Calendar.MINUTE),
                        true);
                timePickerDialog.show();
            }
        });

    }

    private void chooseDay() {
        Calendar calendarDate = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binding.txtDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener callBack = new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                calendarDate.set(Calendar.YEAR, i);
                                calendarDate.set(Calendar.MONTH, i1);
                                calendarDate.set(Calendar.DAY_OF_MONTH, i2);
                                binding.txtDay.setText(dateFormat.format(calendarDate.getTime()));
                            }
                        };
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        InforOrderActivity.this,
                        callBack,
                        calendarDate.get(Calendar.YEAR),
                        calendarDate.get(Calendar.MONTH),
                        calendarDate.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_infor_order_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mn_Hompage){

            Intent intent = new Intent (InforOrderActivity.this,TrangChu.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}