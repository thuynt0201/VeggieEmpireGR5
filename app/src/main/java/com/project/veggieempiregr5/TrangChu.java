package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.adapters.PhotoAdapter;
import com.project.models.Photo;
import com.project.veggieempiregr5.databinding.ActivityTrangChuBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class TrangChu extends AppCompatActivity {


    ActivityTrangChuBinding binding;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Photo> photoList;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager2.getCurrentItem() == photoList.size() - 1) {
                viewPager2.setCurrentItem(0);
            } else {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_trang_chu);
        binding = ActivityTrangChuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //======THANH HEADER======
        getSupportActionBar().setTitle("VEGGIE EMPIRE");
      //  Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_notifications_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======


        viewPager2 = findViewById(R.id.view_pager_2);
        circleIndicator3 = findViewById(R.id.circle_indicator_3);

        photoList = getListPhoto();
        PhotoAdapter adapter = new PhotoAdapter(photoList);
        viewPager2.setAdapter(adapter);

        circleIndicator3.setViewPager(viewPager2);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 2000);
            }
        });

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(TrangChu.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_chat:
                        Intent chat = new Intent(TrangChu.this, HomeChatActivity2.class);
                        startActivity(chat);
                        break;
                    case R.id.action_cart:
                        Intent intent = new Intent(TrangChu.this, MenuActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_coupom:
                        Intent intent1 = new Intent (TrangChu.this, VoucherActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_account:
                        Intent intent2 = new Intent(TrangChu.this, UserInfor.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });

        addEvent();

    }




    private void addEvent() {

        //======NH???N V??O THANH ?????T M??N ????? INTENT QUA M??N H??NH MENUU======
        binding.imvDatMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TrangChu.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        binding.txtXemThucDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TrangChu.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        // tam thoi set cho no vao cai tinh trang don de het loi moi chay dc
        binding.imvStatusOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (TrangChu.this, OrderActivity.class);
                startActivity(intent);
            }
        });
        binding.imvDatBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, ReserveTable.class);
                startActivity(intent);
            }
        });
        binding.txtXemThucDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        binding.txtcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + 01215467));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_FROM_BACKGROUND);
                startActivity(intent);

            }
        });

    }

    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.slide1));
        list.add(new Photo(R.drawable.slide2));
        list.add(new Photo(R.drawable.slide3));
        list.add(new Photo(R.drawable.mixed));
        list.add(new Photo(R.drawable.slide4));
        list.add(new Photo(R.drawable.tofu_trangchu));
        list.add(new Photo(R.drawable.slide5));
        list.add(new Photo(R.drawable.veganfood));
        return list;
    }

    //======MENU======

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_trangchu_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mn_noti){
            Intent intent = new Intent(TrangChu.this, ThongBaoActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.mn_Search){
            Intent intent = new Intent(TrangChu.this, TimKiemMonActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.mn_IntoCart){
            Intent intent = new Intent(TrangChu.this, CartActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}