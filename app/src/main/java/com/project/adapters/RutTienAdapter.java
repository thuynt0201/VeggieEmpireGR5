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
import com.project.veggieempiregr5.ChiTietRutActivity;
import com.project.veggieempiregr5.R;

import java.util.ArrayList;

public class RutTienAdapter extends RecyclerView.Adapter<RutTienAdapter.MyViewHolder>{

    Context context;
    ArrayList id, nguontienrut, sotienrut;

    public RutTienAdapter(Context context, ArrayList id, ArrayList nguontienrut, ArrayList sotienrut){
        this.context = context;
        this.id = id;
        this.nguontienrut = nguontienrut;
        this.sotienrut = sotienrut;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.ruttien_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RutTienAdapter.MyViewHolder holder, final int position) {
        holder.txtNguonTienRut.setText("Rút tiền từ ví về " + String.valueOf(nguontienrut.get(position)));
        holder.txtSoTienRut.setText("- " + String.valueOf(sotienrut.get(position)));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietRutActivity.class);
                intent.putExtra("chitietnguontienrut", String.valueOf(nguontienrut.get(position)));
                intent.putExtra("chitiettienrut", String.valueOf(sotienrut.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNguonTienRut, txtSoTienRut;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNguonTienRut = itemView.findViewById(R.id.txt_NguonTienRutList);
            txtSoTienRut = itemView.findViewById(R.id.txt_SoTienRutList);
            linearLayout = itemView.findViewById(R.id.chitietrut_layout);
        }
    }
}
