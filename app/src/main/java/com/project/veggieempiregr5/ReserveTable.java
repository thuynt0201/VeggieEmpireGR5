package com.project.veggieempiregr5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.database.DatabaseCart;
import com.project.database.DatabaseTable;
import com.project.veggieempiregr5.databinding.ActivityHelpCenterBinding;
import com.project.veggieempiregr5.databinding.ActivityReserveTableBinding;

public class ReserveTable extends AppCompatActivity {

    ActivityReserveTableBinding binding;
    public static DatabaseTable databaseTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reserve_table);

        binding = ActivityReserveTableBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //======THANH HEADER======
        getSupportActionBar().setTitle("Đặt bàn");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
        

    }

    public void datban_click(View view) {

        DatabaseTable myDB = new DatabaseTable(ReserveTable.this);
        myDB.addTable(binding.txtNameTable.getText().toString().trim(),
                Double.parseDouble(binding.txtPhoneTable.getText().toString().trim()),
               Double.parseDouble(binding.txtNumberTable.getText().toString().trim()),
                binding.txtDateTable.getText().toString().trim(),
                binding.txtTimeTable.getText().toString().trim(),
                binding.txtNoteTable.getText().toString().trim());
        Toast.makeText(ReserveTable.this, "Đã lưu thông tin thành công", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Đặt bàn thành công !!!");
        alertDialogBuilder.setIcon(R.drawable.ic_baseline_check_circle_24);
        alertDialogBuilder.setMessage("Về trang chủ?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(ReserveTable.this, TrangChu.class);
                startActivity(intent);
            }
        });
        alertDialogBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ReserveTable.this, "Bạn đã chọn nút hủy", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}