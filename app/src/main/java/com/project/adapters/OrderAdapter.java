package com.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.models.Order;
import com.project.veggieempiregr5.OrderActivity;
import com.project.veggieempiregr5.R;

import java.util.List;

public class OrderAdapter extends BaseAdapter   {

    OrderActivity activity ;
    int item_layout;
    List<Order> orders;

    public OrderAdapter(OrderActivity activity, int item_layout, List<Order> orders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder{
        TextView txtMethodDelivery, txtTime, txtMethodPayment, txtStatus;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.txtMethodDelivery = view.findViewById(R.id.txt_MethodDelivery);
            holder.txtTime = view.findViewById(R.id.txt_TimeOrder);
            holder.txtMethodPayment = view.findViewById(R.id.txt_MethodPayment);
            holder.txtStatus = view.findViewById(R.id.txt_Status);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        Order p = orders.get(i);
        holder.txtMethodDelivery.setText(p.getMethorDelivery());
        holder.txtTime.setText(p.getTime());
        holder.txtMethodPayment.setText(p.getMethorPayment());
        holder.txtStatus.setText(p.getStatus());
        return view;
    }

}
