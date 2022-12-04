package com.project.veggieempiregr5;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

import com.project.adapters.MenuAdapter;
import com.project.models.MenuList;
import com.project.veggieempiregr5.databinding.ActivityMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;
    MenuAdapter adapter;
    List<MenuList> menuList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();


        //======THANH HEADER======
        getSupportActionBar().setTitle("Thực đơn");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======
    }


    private void loadData() {
        menuList = new ArrayList<>();
        menuList.add(new MenuList("Đậu phụ lá lốt cuộn", "Đậu hủ non mềm mịn cùng vị cay thơm của lá lốt tươi.",59000.00,R.drawable.dau_hu_la_lot));
        menuList.add(new MenuList("Súp đậu lăng với nấm", "Nấm rơm và nấm đông cô giòn mềm hòa cùng các loại đậu.",79000.00,R.drawable.soup_dau_lang_voi_nam));
        menuList.add(new MenuList("Cà ri súp lơ", "Súp lơ mềm và giàu dinh dưỡng cùng vị béo dịu của cà ri.",79000.00,R.drawable.ca_ri_sup_lo));
        menuList.add(new MenuList("Cà chua nhồi thịt", "Chua ngọt của cà kết hợp với vị thịt chay đậm đà bắt cơm.",89000.00,R.drawable.kebap_rau_cu));
        menuList.add(new MenuList("Ớt nhồi cơm chiên", "Ớt chuông đỏ ngọt thanh đi kèm cơm chiên dương châu.",109000.00,R.drawable.ot_nhoi_thit_chay));
        menuList.add(new MenuList("Đậu phụ rau diếp cuộn", "Đậu phụ giã nhỏ cuộn cùng rau diếp thơm ngon.",79000.00,R.drawable.dau_hu_rau_diep));
        menuList.add(new MenuList("Soup bí ngô", "Bí đỏ xoay nhuyễn béo bùi. ",59000.00,R.drawable.soup_bi_ngo));
        menuList.add(new MenuList("Salad khoai lang nướng", "Khoai lang mật Đà Lạt cùng rau củ quả. ",79000.00,R.drawable.salad_khoai_lang_nuong));
        menuList.add(new MenuList("Gỏi rau cũ", "Nhiều dinh dưỡng khi kết hợp các loại rau củ.",79000.00,R.drawable.goi_rau_cu));
        menuList.add(new MenuList("Salad khoai tây", "Khoai tây ngọt ngon.",59000.00,R.drawable.salad_khoai_tay));
        menuList.add(new MenuList("Bánh mì rau cũ", "Giòn của bánh mì nóng và rau củ tươi đầy mới lạ độc đáo.",59000.00,R.drawable.banh_mi_rau_cu));
        menuList.add(new MenuList("Mì ramen tỏi mè", "Sợi mì giòn dai,vị thơm tỏi mè",79000.00,R.drawable.mi_ramen_toi_me));
        menuList.add(new MenuList("Phô mai nướng", "Hoàn hảo",79000.00,R.drawable.pho_mai_nuong));
        menuList.add(new MenuList("Lẩu chay shabu shabu", "",209000.00,R.drawable.lau_shabu_shabu));
        menuList.add(new MenuList("Trà hoa cúc", "",29000.00,R.drawable.hoa_cuc));
        menuList.add(new MenuList("Trà đá việt quất", "",29000.00,R.drawable.viet_quat));
        menuList.add(new MenuList("Nước ép cà rốt", "",29000.00,R.drawable.ca_rot));
        menuList.add(new MenuList("Nước ép dứa ", "",29000.00,R.drawable.nuoc_ep_dua));
        adapter = new MenuAdapter(MenuActivity.this, R.layout.item_menu, menuList);
        binding.lvMenuDish.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



}