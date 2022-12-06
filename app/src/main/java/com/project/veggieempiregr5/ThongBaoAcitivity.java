//package com.project.veggieempiregr5;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import com.project.adapters.ThongBaoAdapter;
//import com.project.models.ThongBao;
//
//import java.util.ArrayList;
//
//public class ThongBaoAcitivity extends AppCompatActivity {
//
//    //Phan nay cua chi Phuonng Phuong
//    ListView lvThongBao;
//    ArrayList<ThongBao> arrayThongBao;
//    ThongBaoAdapter adapterthongbao;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thong_bao_acitivity);
//
//        arrayThongBao = new ArrayList<>();
//        lvThongBao= (ListView) findViewById(R.id.lvthongbao);
//
//        arrayThongBao.add(new ThongBao("ĐƠN HÀNG ĐÃ TỚI RỒI ", "Mã đơn hàng ĐKE2524", "20 phút nữa bác tài sẽ giao tới bạn","10:20","22/10/2022",R.drawable.logo));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", " "," ",R.drawable.logo));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022"," "," ",R.drawable.logo));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022"," "," ",R.drawable.logo));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022"," "," ",R.drawable.logo));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", " "," ",R.drawable.logo));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022"," "," ",R.drawable.logo ));
//        arrayThongBao.add(new ThongBao("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", " "," ",R.drawable.logo));
//        adapterthongbao=new ThongBaoAdapter(this, R.layout.dong_thong_bao,arrayThongBao);
//        lvThongBao.setAdapter(adapterthongbao);
//    }
//}