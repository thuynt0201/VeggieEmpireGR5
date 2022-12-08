package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.project.veggieempiregr5.databinding.ActivityAccountSecurityBinding;
import com.project.veggieempiregr5.databinding.ActivityEditInfAcountBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditInfAcountActivity extends AppCompatActivity {


    ActivityEditInfAcountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_inf_acount);

        binding = ActivityEditInfAcountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Chỉnh sửa thông tin");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

        addEvent();
        chooseDay();

    }

    private void addEvent() {
        binding.btnLuuthongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditInfAcountActivity.this, "Bạn lưu thông tin thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void chooseDay() {
        Calendar calendarDate = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binding.txtNgaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener callBack = new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                calendarDate.set(Calendar.YEAR, i);
                                calendarDate.set(Calendar.MONTH, i1);
                                calendarDate.set(Calendar.DAY_OF_MONTH, i2);
                                binding.txtNgaysinh.setText(dateFormat.format(calendarDate.getTime()));
                            }
                        };
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        EditInfAcountActivity.this,
                        callBack,
                        calendarDate.get(Calendar.YEAR),
                        calendarDate.get(Calendar.MONTH),
                        calendarDate.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }


}