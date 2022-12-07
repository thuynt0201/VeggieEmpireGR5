package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.project.adapters.ThongBaoAdapter;
import com.project.adapters.VoucherAdapter;
import com.project.models.Thongbao;

import java.util.ArrayList;

public class ThongBaoActivity extends AppCompatActivity {

    private RecyclerView rcvThongBao;
    private ArrayList<Thongbao> arrayThongBao;
    private ThongBaoAdapter adapterthongbao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);

        arrayThongBao = new ArrayList<>();
        arrayThongBao.add(new Thongbao("ĐƠN HÀNG ĐÃ ĐẾN RỒI BẠN ƠI","Mã đơn hàng AGV18511","20 phút nữa bác tài sẽ tới!!!!","20:13","24/12/2022"));
        arrayThongBao.add(new Thongbao("ĐƠN HÀNG ĐÃ ĐẾN RỒI BẠN ƠI","Mã đơn hàng AGV18511","20 phút nữa bác tài sẽ tới!!!!","20:13","24/12/2022"));
        arrayThongBao.add(new Thongbao("ĐƠN HÀNG ĐÃ ĐẾN RỒI BẠN ƠI","Mã đơn hàng AGV18511","20 phút nữa bác tài sẽ !!!!","20:13","24/12/2022"));
        arrayThongBao.add(new Thongbao("ĐƠN HÀNG ĐÃ ĐẾN RỒI BẠN ƠI","Mã đơn hàng AGV18511","20 phút nữa bác tài sẽ tới!!!!","20:13","24/12/2022"));
        arrayThongBao.add(new Thongbao("ĐƠN HÀNG ĐÃ ĐẾN RỒI BẠN ƠI","Mã đơn hàng AGV18511","20 phút nữa bác tài sẽ tới!!!!","20:13","24/12/2022"));
        arrayThongBao.add(new Thongbao("ĐƠN HÀNG ĐÃ ĐẾN RỒI BẠN ƠI","Mã đơn hàng AGV18511","20 phút nữa bác tài sẽ tới!!!!","20:13","24/12/2022"));
        rcvThongBao=findViewById(R.id.rcvthongbao);
        //dsticket = new ArrayList<>();
        ThongBaoAdapter adapter = new ThongBaoAdapter(arrayThongBao);
        rcvThongBao.setLayoutManager(new LinearLayoutManager(this));
        rcvThongBao.setAdapter(adapter);

        //List ticket



    }

}