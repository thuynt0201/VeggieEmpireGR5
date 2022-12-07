package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.project.veggieempiregr5.databinding.ActivityNhapOtpBinding;

public class NhapOTPActivity extends AppCompatActivity {
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;
    ActivityNhapOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_nhap_otp);

        getSupportActionBar().setTitle("Nhập mã xác thực OTP");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        binding = ActivityNhapOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sendnoti();
        addEvents();
        
    }

    private void sendnoti() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myCh", "Mychannel", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setContentTitle("Bạn đã thêm thẻ thành công")
                .setContentText("Thêm thẻ ngân hàng thành công, bắt đầu mua sắm cùng Veggie nào!!");
        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    private void addEvents() {
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManagerCompat.notify(1, notification);
                Intent intent = new Intent(NhapOTPActivity.this, ConnectSuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}