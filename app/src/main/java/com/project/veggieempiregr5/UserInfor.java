package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.veggieempiregr5.databinding.ActivityKhuyenMaiBinding;
import com.project.veggieempiregr5.databinding.ActivityTrangChuBinding;
import com.project.veggieempiregr5.databinding.ActivityUserInforBinding;

public class UserInfor extends AppCompatActivity {

    ImageView imguser;

    ActivityUserInforBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user_infor);

        binding = ActivityUserInforBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
        //======THANH HEADER======
        getSupportActionBar().setTitle("Tài khoản");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
    }

    private void addEvents() {
        binding.txtWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, Wallet.class);
                startActivity(intent2);
            }
        });
        binding.txtTaiKhoanBaoMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, AccountSecurity.class);
                startActivity(intent2);
            }
        });
        binding.txtAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, Address.class);
                startActivity(intent2);
            }
        });
        binding.txtNotiSettings.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, NotiSettings.class);
                startActivity(intent2);
            }
        }));
        binding.txtLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, Language.class);
                startActivity(intent2);
            }
        });
        binding.txtHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, HelpCenter.class);
                startActivity(intent2);
            }
        });
        binding.txtContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, Contact.class);
                startActivity(intent2);
            }
        });
        binding.txtKhuyenMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(UserInfor.this, VoucherActivity.class);
                startActivity(intent2);
            }
        });

        binding.txtChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfor.this, SMSActivity2.class);
                startActivity(intent);
            }
        });
        binding.txtOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfor.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        imguser = (ImageView)findViewById(R.id.imguser);
        binding.imguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open();
            }
        });
    }
        public void open(){
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imguser.setImageBitmap(bp);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        return true;


    }

    public void logout_click(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Xác nhận để thoát..!!!");
        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setMessage("Bạn có chắc chắn muốn thoát?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(UserInfor.this, loginActivity2.class);
                startActivity(intent);
            }
        });
        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(UserInfor.this, "Bạn đã chọn vào nút không đồng ý", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(UserInfor.this, "Bạn đã chọn nút hủy", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}