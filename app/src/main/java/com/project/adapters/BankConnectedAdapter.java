package com.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.veggieempiregr5.R;

import java.util.ArrayList;

public class BankConnectedAdapter extends RecyclerView.Adapter<BankConnectedAdapter.MyViewHolder>{
    private Context context;
    private ArrayList bankName;

    public BankConnectedAdapter(Context context, ArrayList bankName){
        this.context = context;
        this.bankName = bankName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_bank, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtBankName.setText(String.valueOf(bankName.get(position)));
    }

    @Override
    public int getItemCount() {
        return bankName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtBankName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBankName = itemView.findViewById(R.id.txt_BankName);
        }
    }
}
