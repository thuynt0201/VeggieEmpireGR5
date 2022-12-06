package com.project.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.models.Bank;
import com.project.veggieempiregr5.LienKetActivity;
import com.project.veggieempiregr5.R;

import java.util.ArrayList;
import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder> implements Filterable {
    private List<Bank> bankList, bankOldList;
    private Context context;

    public BankAdapter(Context context,List<Bank> bankList) {
        this.bankList = bankList;
        this.bankOldList = bankList;
        this.context = context;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banklist, parent, false);
        return new BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {
        final Bank bank = bankList.get(position);
        if (bank == null){
            return;
        }
        holder.imvBankLogo.setImageResource(bank.getBankLogo());
        holder.txtBankName.setText(bank.getBankName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(bank);
            }
        });
    }

    private void onClickGoToDetail(Bank bank){
        Intent intent = new Intent(context, LienKetActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("bank_name", bank);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (bankList != null ){
            return bankList.size();
        }
        return 0;
    }



    public class BankViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private ImageView imvBankLogo;
        private TextView txtBankName;

        public BankViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.bank_item);
            imvBankLogo = itemView.findViewById(R.id.imv_Logo);
            txtBankName = itemView.findViewById(R.id.txt_Bank);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if (strSearch.isEmpty()){
                    bankList = bankOldList;
                } else {
                    List<Bank> banks = new ArrayList<>();
                    for (Bank bank : bankOldList){
                        if (bank.getBankName().toLowerCase().contains(strSearch.toLowerCase())){
                            banks.add(bank);
                        }
                    }

                    bankList = banks;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = bankList;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                bankList = (List<Bank>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
