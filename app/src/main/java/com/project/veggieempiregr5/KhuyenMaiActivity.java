//package com.project.veggieempiregr5;
////
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import com.project.adapters.KhuyenMaiAdapter;
//import com.project.models.KhuyenMai;
//
//import java.util.ArrayList;
//
//public class KhuyenMaiActivity extends AppCompatActivity {
//
//    phan nay chi phuong
//    ListView lvKhuyenMai;
//    ArrayList<KhuyenMai> arrayKhuyenMai;
//    KhuyenMaiAdapter adapterkhuyenmai;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_khuyen_mai);
//        arrayKhuyenMai = new ArrayList<>();
//        lvKhuyenMai = (ListView) findViewById(R.id.lvkhuyenmai);
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        arrayKhuyenMai.add(new KhuyenMai("[SIÊU DEAL] ", "Súp đậu lăng, Mì ý rau củ ăn kèm với Salad thơm ngon", "22/11/2022", R.drawable.logo));
//        adapterkhuyenmai=new KhuyenMaiAdapter(this, R.layout.dong_khuyen_mai,arrayKhuyenMai);
//        lvKhuyenMai.setAdapter(adapterkhuyenmai);
//    }
//}