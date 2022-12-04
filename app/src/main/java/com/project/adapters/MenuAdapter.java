package com.project.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.models.MenuList;
import com.project.veggieempiregr5.R;

import java.util.List;

public class MenuAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<MenuList> menuList;

    public MenuAdapter(Activity activity, int item_layout, List<MenuList> menuList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.menuList = menuList;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int i) {
        return menuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    public static class ViewHolder{
        ImageView imvDish;
        TextView txtName, txtDes, txtPrice;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null) {
            holder = new ViewHolder();
            // LayoutInflater inflater = activity.getLayoutInflater(Context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.item_layout, null);

            //Link views

            holder.txtName = view.findViewById(R.id.txt_NameMenu);
            holder.txtDes = view.findViewById(R.id.txt_DesMenu);
            holder.txtPrice = view.findViewById(R.id.txt_PriceMenu);
            holder.imvDish= view.findViewById(R.id.imv_Dishes);

            view.setTag(holder); //lưu lại khi đã link xong
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //binding data

        MenuList menu = menuList.get(i);

        holder.txtName.setText(menu.getName());
        holder.txtDes.setText(menu.getDes());
        holder.txtPrice.setText(String.valueOf(menu.getPrice())); //convert chuỗi
        holder.imvDish.setImageResource(menu.getImage());

        return view;
    }
}
