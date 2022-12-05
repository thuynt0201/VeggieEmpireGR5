package com.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.models.KhuyenMai;
import com.project.veggieempiregr5.R;

import java.util.List;

public class KhuyenMaiAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<KhuyenMai> khuyenMaiList;

    public KhuyenMaiAdapter(Context context, int layout, List<KhuyenMai> khuyenMaiList) {
        this.context = context;
        this.layout = layout;
        this.khuyenMaiList = khuyenMaiList;
    }

    @Override
    public int getCount() {
        return khuyenMaiList.size();
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

        TextView txttenkhuyenmai=(TextView) view.findViewById(R.id.txttenkhuyenmai);
        TextView txtmotakhuyenmai=(TextView) view.findViewById(R.id.txtmotakhuyenmai);
        TextView txtthoigiankhuyenmai=(TextView) view.findViewById(R.id.txtthoigiankhuyenmai);
        ImageView imageHinhkhuyenmai=(ImageView) view.findViewById(R.id.imagekhuyenmai);


        txttenkhuyenmai.setText(khuyenMaiList.get(i).TenKhuyenMai);
        txtmotakhuyenmai.setText(khuyenMaiList.get(i).MotaKhuyenMai);
        txtthoigiankhuyenmai.setText(khuyenMaiList.get(i).ThoigianKhuyenMai);
        imageHinhkhuyenmai.setImageResource(khuyenMaiList.get(i).HinhKhuyenMai);
        return view;
    }
}
