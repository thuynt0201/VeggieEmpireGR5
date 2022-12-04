package com.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.models.Item;
import com.project.veggieempiregr5.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    public ItemAdapter(List<Item> itemList){ this.itemList = itemList; }

    public void setFilteredList(List<Item> filteredList){
        this.itemList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timkiemmon, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item item = itemList.get(position);
        if (item == null){
            return;
        }
        holder.imgItem.setImageResource(item.getImage());
        holder.tvName.setText(item.getName());
    }
    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public Object linearLayout;
        private ImageView imgItem;
        private TextView tvName;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_Item);
            tvName = itemView.findViewById(R.id.tv_Name);
        }
    }
}
