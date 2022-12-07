package com.project.veggieempiregr5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.project.adapters.LocationAdapter;
import com.project.models.Item;
import com.project.models.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {

    private RecyclerView rcvLocation;
    private List<Location> locationList;
    private LocationAdapter locationAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //======THANH HEADER======
        getSupportActionBar().setTitle("Chọn địa chỉ nhận hàng");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

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
                return true;
            }
        });

        rcvLocation= findViewById(R.id.rcv_Location);
        rcvLocation.setHasFixedSize(true);
        rcvLocation.setLayoutManager(new LinearLayoutManager(this));
        locationList = new ArrayList<>();

        // add data to item List

        locationList.add(new Location("Trường ĐH Kinh tế - Luật", "Linh Xuân, Thủ Đức, Thành phố Hồ Chí Minh"));
        locationList.add(new Location("Học viện Hàng không Việt Nam", "Đường Cộng Hòa, Phường 4, Thành phố Hồ Chí Minh"));
        locationList.add(new Location("Học viện Cán Bộ TPHCM", "Chu Văn An, Phường 12, Bình Thạnh"));
        locationList.add(new Location("Căn hộ Saigon Mia", "Đường số 9A, khu dân cư Trung Sơn"));

        locationAdapter = new LocationAdapter(locationList);
        rcvLocation.setAdapter(locationAdapter);
    }

    private void filterList(String text) {
        List<Location> filteredList = new ArrayList<>();
        for (Location location : locationList){
            if(location.getName().toLowerCase().contains(text.toLowerCase(Locale.ROOT))){
                filteredList.add(location);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "Không tìm thấy địa chỉ này!", Toast.LENGTH_SHORT).show();
        }else {
            locationAdapter.setFilteredList(filteredList);
        }
    }

}
