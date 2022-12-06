package com.project.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.models.Item;
import com.project.veggieempiregr5.MenuDetailActivity;
import com.project.veggieempiregr5.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private Context mContext;

    public ItemAdapter(Context context,List<Item> itemList){
        this.mContext = context;
        this.itemList = itemList;
    }

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
        holder.layoutItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onClickGoToDetailMenu(item);
            }
        });
    }

    private void onClickGoToDetailMenu(Item item) {
        Intent intent = new Intent(mContext, MenuDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_item", item);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void release(){
        mContext = null;
    }
    
    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout layoutItem;
        private ImageView imgItem;
        private TextView tvName;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgItem = itemView.findViewById(R.id.img_Item);
            tvName = itemView.findViewById(R.id.tv_Name);
        }
    }
}
