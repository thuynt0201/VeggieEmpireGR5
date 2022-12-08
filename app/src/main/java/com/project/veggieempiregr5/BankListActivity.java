package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;

import com.project.adapters.BankAdapter;
import com.project.models.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankListActivity extends AppCompatActivity {

    BankAdapter adapter;

    RecyclerView rcvBank;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);

        getSupportActionBar().setTitle("Chọn ngân hàng");


        rcvBank = findViewById(R.id.rcv_Bank); //ánh xạ rcvBank
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this); //xác định layout manager sẽ sử dụng
        rcvBank.setLayoutManager(linearLayoutManager);

        adapter = new BankAdapter(this, getListBank()); //khởi tạo adapter - cần 1 list dữ liệu
        rcvBank.setAdapter(adapter); // set adapter cho rcv

        //Thêm dòng kẻ giữa các item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvBank.addItemDecoration(itemDecoration);

    }

    private List<Bank> getListBank() {
        List<Bank> banks = new ArrayList<>();
        banks.add(new Bank(R.drawable.vietcombank, "Vietcombank"));
        banks.add(new Bank(R.drawable.agribank, "Agribank"));
        banks.add(new Bank(R.drawable.acbbank, "ACBBank"));
        banks.add(new Bank(R.drawable.mbbank, "MBBank"));
        banks.add(new Bank(R.drawable.sacombank, "SacomBank"));
        banks.add(new Bank(R.drawable.vietinbank, "VietinBank"));
        banks.add(new Bank(R.drawable.techcombank, "TechcomBank"));
        banks.add(new Bank(R.drawable.acbbank, "ACBBank"));
        banks.add(new Bank(R.drawable.abbank, "ABBank"));
        banks.add(new Bank(R.drawable.bacabank, "BacABank"));
        banks.add(new Bank(R.drawable.banvietbank, "BanVietBank"));
        banks.add(new Bank(R.drawable.baovietbank, "BaoVietBank"));
        banks.add(new Bank(R.drawable.bidvbank, "BIDV"));
        banks.add(new Bank(R.drawable.tpbank, "TPBank"));
        banks.add(new Bank(R.drawable.vpbank, "VPBank"));
        banks.add(new Bank(R.drawable.eximbank, "EximBank"));
        banks.add(new Bank(R.drawable.gpbank, "GPBank"));
        banks.add(new Bank(R.drawable.msbbank, "MSBBank"));
        banks.add(new Bank(R.drawable.indovinabank, "Indovina"));
        banks.add(new Bank(R.drawable.kienlongbank, "KienLongBank"));
        banks.add(new Bank(R.drawable.lienvietpostbank, "LienVietPost"));
        banks.add(new Bank(R.drawable.ocbbank, "OCBBank"));
        banks.add(new Bank(R.drawable.hdbank, "HDBank"));

        return banks;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bank_search_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.mn_BankSearch).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()){
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}