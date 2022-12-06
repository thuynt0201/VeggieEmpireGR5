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

import com.project.veggieempiregr5.ChiTietNapActivity;
import com.project.veggieempiregr5.R;

import java.util.ArrayList;

public class NapTienAdapter extends RecyclerView.Adapter<NapTienAdapter.MyViewHolder> {

    Context context;
    ArrayList id, nguontien, sotiennap;

    public NapTienAdapter(Context context, ArrayList id, ArrayList nguontien, ArrayList sotiennap){
        this.context = context;
        this.id = id;
        this.nguontien = nguontien;
        this.sotiennap = sotiennap;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.naptien_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NapTienAdapter.MyViewHolder holder, final int position) {

        holder.txtNguonTienNap.setText("Nạp tiền vào ví từ " + String.valueOf(nguontien.get(position)));
        holder.txtSoTienNap.setText("+ " + String.valueOf(sotiennap.get(position)));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietNapActivity.class);
                intent.putExtra("chitietnguontien", String.valueOf(nguontien.get(position)));
                intent.putExtra("chitiettiennap", String.valueOf(sotiennap.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNguonTienNap, txtSoTienNap;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNguonTienNap = itemView.findViewById(R.id.txt_NguonTienList);
            txtSoTienNap = itemView.findViewById(R.id.txt_SoTienNapList);
            linearLayout = itemView.findViewById(R.id.chitiet_layout);
        }
    }
}
