package com.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.models.Cart;
import com.project.veggieempiregr5.CartActivity;
import com.project.veggieempiregr5.R;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    private CartActivity context;
    private  int layout;
    private ArrayList<Cart> cartArrayList;

    public CartAdapter(CartActivity context, int layout, ArrayList<Cart> cartArrayList) {
        this.context = context;
        this.layout = layout;
        this.cartArrayList = cartArrayList;
    }

    @Override
    public int getCount() {
        return cartArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private class ViewHolder{
        //ImageView imageDishDetail;
        TextView txtNamedetail, txtPriceDetail,txtNumberInCart,txtTotal;
        ImageView imageMinus, imagePlus,imageDelete;
        Button btnStartOrder;


    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtNamedetail = (TextView) row.findViewById(R.id.txt_NameCart);
            holder.txtPriceDetail = (TextView) row.findViewById(R.id.txt_PriceCart);
            holder.txtNumberInCart = (TextView) row.findViewById(R.id.txt_NumberIncart);
            holder.txtTotal = (TextView) row.findViewById(R.id.txt_Total);
            holder.imageMinus = row.findViewById(R.id.imgbtn_minus);
            holder.imagePlus = row.findViewById(R.id.imgbtn_plus);
            holder.imageDelete = row.findViewById(R.id.imv_DeteleCart);


            //holder.imageDishDetail= (ImageView) row.findViewById(R.id.imv_DishesCart);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }


        Cart cart = cartArrayList.get(position);
        holder.txtNamedetail.setText(cart.getNameDishCart());
        holder.txtPriceDetail.setText(cart.getPriceEachDishCart().toString());
        holder.txtNumberInCart.setText(String.valueOf(cart.getNumberEachDishCart()));
        holder.txtTotal.setText(cart.getTotalEachDishCart().toString());
        holder.imageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.imagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogDeleteCart(cart.getNameDishCart(),cart.getId());
            }
        });


//        byte[] productImage = cart.getImagedetail();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(productImage, 0, productImage.length);
//        holder.imageDishDetail.setImageBitmap(bitmap);
        return row;
    }
}
