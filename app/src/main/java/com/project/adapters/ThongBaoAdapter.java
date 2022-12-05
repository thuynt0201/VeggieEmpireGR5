package com.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.models.ThongBao;
import com.project.veggieempiregr5.R;

import java.util.List;

public class ThongBaoAdapter extends BaseAdapter  {
    Context context;
    int layout;
    List<ThongBao> thongbaoList;

    public ThongBaoAdapter(Context context, int layout, List<ThongBao> thongbaoList) {
        this.context = context;
        this.layout = layout;
        this.thongbaoList = thongbaoList;
    }

    @Override
    public int getCount() {
        return thongbaoList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView txttenthongbao=(TextView) view.findViewById(R.id.txttenthongbao);
        TextView txtmathongbao=(TextView) view.findViewById(R.id.txtmathongbao);
        TextView txtmotathongbao=(TextView) view.findViewById(R.id.txtmotathongbao);
        TextView txtthoigianthongbao=(TextView) view.findViewById(R.id.txtthoigianthongbao);
        TextView txtngaythongbao=(TextView) view.findViewById(R.id.txttngaythongbao);
        ImageView imageHinhthongbao=(ImageView) view.findViewById(R.id.imagethongbao);


        txttenthongbao.setText(thongbaoList.get(i).Tenthongbao);
        txtmathongbao.setText(thongbaoList.get(i).Mathongbao);
        txtmotathongbao.setText(thongbaoList.get(i).Motathongbao);
        txtngaythongbao.setText(thongbaoList.get(i).Ngaythongbao);
        txtthoigianthongbao.setText(thongbaoList.get(i).Thoigianthongbao);
        imageHinhthongbao.setImageResource(thongbaoList.get(i).Hinhthongbao);
        return view;
    }
}
