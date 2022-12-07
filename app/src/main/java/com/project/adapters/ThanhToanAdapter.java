package com.project.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.veggieempiregr5.ChiTietThanhToanActivity;
import com.project.veggieempiregr5.R;

import java.util.ArrayList;

public class ThanhToanAdapter extends RecyclerView.Adapter<ThanhToanAdapter.MyViewHolder>{

    Context context;
    ArrayList id, sotienthanhtoan;

    public ThanhToanAdapter(Context context, ArrayList id, ArrayList sotienthanhtoan){
        this.context = context;
        this.id = id;
        this.sotienthanhtoan = sotienthanhtoan;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.thanhtoanlist_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhToanAdapter.MyViewHolder holder, int position) {
        holder.txtSoTienThanhToan.setText("- " + String.valueOf(sotienthanhtoan.get(position)));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietThanhToanActivity.class);
                intent.putExtra("chitiettienthanhtoan", String.valueOf(sotienthanhtoan.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtSoTienThanhToan;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSoTienThanhToan = itemView.findViewById(R.id.txt_SoTienThanhToanList);
            linearLayout = itemView.findViewById(R.id.chitietthanhtoan_layout);
        }
    }
}
