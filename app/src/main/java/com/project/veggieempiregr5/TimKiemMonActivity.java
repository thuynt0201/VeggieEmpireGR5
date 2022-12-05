package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.project.adapters.ItemAdapter;
import com.project.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TimKiemMonActivity extends AppCompatActivity {

    private RecyclerView rcvItem;
    private List<Item> itemList;
    private ItemAdapter itemAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem_mon);

        getSupportActionBar().setTitle(" ");

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });

        rcvItem = findViewById(R.id.rcv_Item);
        rcvItem.setHasFixedSize(true);
        rcvItem.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();

        // add data to item List

        itemList.add(new Item(R.drawable.banh_mi_rau_cu, "Bánh mì rau củ"));
        itemList.add(new Item(R.drawable.ca_chua, "Cà chua nhồi thịt chay"));
        itemList.add(new Item(R.drawable.ca_ri_sup_lo, "Cà ri súp lơ"));
        itemList.add(new Item(R.drawable.dau_hu_la_lot, "Đậu phụ lá lốt cuộn"));
        itemList.add(new Item(R.drawable.dau_hu_rau_diep, "Đậu phụ rau diếp cuộn"));
        itemList.add(new Item(R.drawable.goi_rau_cu, "Gỏi rau củ"));
        itemList.add(new Item(R.drawable.lau_shabu_shabu, "Lẩu chay shabu shabu"));
        itemList.add(new Item(R.drawable.lau_thai, "Lẩu thái chay"));
        itemList.add(new Item(R.drawable.lau_truyen_thong, "Lẩu chay truyền thống"));
        itemList.add(new Item(R.drawable.mi_ramen_toi_me, "Mì ramen tỏi mè"));
        itemList.add(new Item(R.drawable.ot_nhoi_thit_chay, "Ớt nhồi cơm chiên"));
        itemList.add(new Item(R.drawable.pho_mai_nuong, "Phô mai nướng"));
        itemList.add(new Item(R.drawable.pizza_chay, "Pizza chay"));
        itemList.add(new Item(R.drawable.salad_khoai_lang_nuong, "Salad khoai lang nướng"));
        itemList.add(new Item(R.drawable.salad_khoai_tay, "Salad khoai tây"));
        itemList.add(new Item(R.drawable.soup_bi_ngo, "Soup bí ngô"));
        itemList.add(new Item(R.drawable.soup_dau_lang_voi_nam, "Soup đậu lăng với nấm"));
        itemList.add(new Item(R.drawable.soup_rau_thap_cam, "Soup rau thập cẩm"));
        itemList.add(new Item(R.drawable.tra_hoa_hong, "Trà hoa hồng"));
        itemList.add(new Item(R.drawable.viet_quat, "Trà đá việt quất chanh bạc hà"));
        itemList.add(new Item(R.drawable.hoa_cuc, "Trà hoa cúc"));
        itemList.add(new Item(R.drawable.ca_rot, "Nước ép cà rốt"));
        itemList.add(new Item(R.drawable.cam_ep, "Nước ép cam"));
        itemList.add(new Item(R.drawable.nuoc_ep_dua, "Nước ép dứa"));
        itemList.add(new Item(R.drawable.nuoc_chanh_tuoi, "Nước chanh tươi"));
        itemList.add(new Item(R.drawable.nuoc_mia, "Nước mía"));
        itemList.add(new Item(R.drawable.nuoc_sam, "Nước sâm"));

        itemAdapter = new ItemAdapter(itemList);
        rcvItem.setAdapter(itemAdapter);
    }

    private void filterList(String text) {
        List<Item> filteredList = new ArrayList<>();
        for (Item item : itemList){
            if(item.getName().toLowerCase().contains(text.toLowerCase(Locale.ROOT))){
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "Không tìm thấy món ăn!", Toast.LENGTH_SHORT).show();
        }else {
            itemAdapter.setFilteredList(filteredList);
        }
    }

}