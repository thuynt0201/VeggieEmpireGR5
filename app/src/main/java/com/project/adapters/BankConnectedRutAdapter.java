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

import com.project.veggieempiregr5.R;
import com.project.veggieempiregr5.RutTienActivity;

import java.util.ArrayList;

public class BankConnectedRutAdapter extends RecyclerView.Adapter<BankConnectedRutAdapter.MyViewHolder>{

    private Context context;

    private ArrayList bankName;

    public BankConnectedRutAdapter(Context context, ArrayList bankName){
        this.context = context;
        this.bankName = bankName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_bank, parent, false);
        return new BankConnectedRutAdapter.MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull BankConnectedRutAdapter.MyViewHolder holder, final int position) {
        holder.txtBankName.setText(String.valueOf(bankName.get(position)));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RutTienActivity.class);
                intent.putExtra("bankname", String.valueOf(bankName.get(position)));
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return bankName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtBankName;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBankName = itemView.findViewById(R.id.txt_BankName);
            linearLayout = itemView.findViewById(R.id.banklist_item);
        }
    }
}
