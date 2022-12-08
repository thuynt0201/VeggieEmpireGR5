package com.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.models.Location;
import com.project.veggieempiregr5.R;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<Location> locationList;

    public LocationAdapter(List<Location> locationList) {
        this.locationList =locationList;
    }

    public void setFilteredList(List<Location> filteredList){
        this.locationList = filteredList;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        return new LocationViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        final Location location = locationList.get(position);
        if (location == null){
            return;
        }
        holder.tvName.setText(location.getName());
        holder.tvDes.setText(location.getDes());
    }
    @Override
    public int getItemCount() {
        if (locationList != null) {
            return locationList.size();
        }
        return 0;
    }

    public Location getItemCount(int position) {
        locationList.size();
        return null;
    }


    public class LocationViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvDes;
        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_NameLoca);
            tvDes = itemView.findViewById(R.id.tv_Des);
        }
    }
}
