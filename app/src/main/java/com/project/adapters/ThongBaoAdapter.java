package com.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.models.Thongbao;
import com.project.models.Voucher;
import com.project.veggieempiregr5.R;

import java.util.List;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ViewHolder> {
    private List<Thongbao> thongbaoList;
    public ThongBaoAdapter(List<Thongbao> thongbaoList){this.thongbaoList=thongbaoList;}

    public void setOnItemClick(OnItemClick event) {
        callBack = event;
    }

    private OnItemClick callBack;

    public interface OnItemClick {
        void onItemClick(Thongbao data);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.dong_thong_bao, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Thongbao data = thongbaoList.get(position);
        holder.txttenthongbao.setText(data.getTenthongbao());
        holder.txtmathongbao.setText(data.getMathongbao());
        holder.txtmotathongbao.setText(data.getMotathongbao());
        holder.txtthoigianthongbao.setText(data.getThoigianthongbao());
        holder.txtngaythongbao.setText(data.getNgaythongbao());
        holder.thongbao =  thongbaoList.get(position);
    }

    @Override
    public int getItemCount() {
        return thongbaoList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenthongbao;
        TextView txtmathongbao;
        TextView txtmotathongbao;
        TextView txtthoigianthongbao;
       TextView txtngaythongbao;
        Thongbao thongbao;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtmathongbao = itemView.findViewById(R.id.txtmathongbao);
            txttenthongbao = itemView.findViewById(R.id.txttenthongbao);
            txtmotathongbao = itemView.findViewById(R.id.txtmotathongbao);
            txtthoigianthongbao = itemView.findViewById(R.id.txtthoigianthongbao);
            txtngaythongbao = itemView.findViewById(R.id.txttngaythongbao);

            itemView.setTag(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callBack.onItemClick(thongbao);
                }
            });
        }
    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        view = inflater.inflate(layout,null);
//
//        TextView txttenthongbao=(TextView) view.findViewById(R.id.txttenthongbao);
//        TextView txtmathongbao=(TextView) view.findViewById(R.id.txtmathongbao);
//        TextView txtmotathongbao=(TextView) view.findViewById(R.id.txtmotathongbao);
//        TextView txtthoigianthongbao=(TextView) view.findViewById(R.id.txtthoigianthongbao);
//        TextView txtngaythongbao=(TextView) view.findViewById(R.id.txttngaythongbao);
//        ImageView imageHinhthongbao=(ImageView) view.findViewById(R.id.imagethongbao);
//
//
//        txttenthongbao.setText(thongbaoList.get(i).Tenthongbao);
//        txtmathongbao.setText(thongbaoList.get(i).Mathongbao);
//        txtmotathongbao.setText(thongbaoList.get(i).Motathongbao);
//        txtngaythongbao.setText(thongbaoList.get(i).Ngaythongbao);
//        txtthoigianthongbao.setText(thongbaoList.get(i).Thoigianthongbao);
//        imageHinhthongbao.setImageResource(thongbaoList.get(i).Hinhthongbao);
//        return view;
//    }
}
