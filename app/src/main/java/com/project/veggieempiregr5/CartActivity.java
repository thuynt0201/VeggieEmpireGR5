package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.adapters.CartAdapter;
import com.project.database.DatabaseCart;
import com.project.models.Cart;
import com.project.veggieempiregr5.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;
    ArrayList<Cart> cartArrayList;
    CartAdapter adapter = null;
    DatabaseCart myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cartArrayList = new ArrayList<>();
        adapter = new CartAdapter(this, R.layout.item_cart, cartArrayList);
        binding.lvCartDishes.setAdapter(adapter);


        //======THANH HEADER======
        getSupportActionBar().setTitle("Giỏ hàng");
        Drawable drawable= getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        //======THANH HEADER END======

        getData();

        getDataCoupon();
        totalPrice();
        addEvent();


    }

    private void addEvent() {
        binding.chooseCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (CartActivity.this,CouponCodeOrderActivity.class);
                startActivity(intent);
            }
        });
    }


    private void getDataCoupon() {


    }

    private void totalPrice(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int value = 0;
        if(bundle !=null)
        {
            value = bundle.getInt("coupon",0);

        }        //Bundle bundle = getIntent().getExtras();
        binding.txtDiscountCart.setText(String.valueOf(value)+"đ");

        int total = 0;
        for(int i=0;i<cartArrayList.size();i++)
        {
            total = (int) (total+cartArrayList.get(i).getTotalEachDishCart());
        }
        binding.txtTotalAllItemCart.setText(String.valueOf(total)+"đ");
        int totalOrder = 0;
        totalOrder = (int)(total -value);
        binding.txtTotalCart.setText(String.valueOf(totalOrder)+"đ");
    }


    private void getData() {
        // get all data from sqlite
        //Cursor cursor = MenuDetailActivity.databaseCart.getData("SELECT * FROM CART");
        myDB = new DatabaseCart(CartActivity.this);
        Cursor cursor = myDB.readAllData();
        cartArrayList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nameCart = cursor.getString(1);
            Double priceCart= cursor.getDouble(2);
            int numberCart= cursor.getInt(3);
            Double totalCart= cursor.getDouble(4);
            //byte[] imagedetail = cursor.getBlob(3);
            cartArrayList.add(new Cart(id, nameCart, priceCart,numberCart,totalCart));        }
        adapter.notifyDataSetChanged();
    }


    public void DialogDeleteCart(String tenCV, int Id){

        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(CartActivity.this);
        dialogXoa.setMessage("Bạn có muốn xóa "+ tenCV +" hay không?");

        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //MenuDetailActivity.databaseCart.queryData("DELETE FROM CART WHERE Id = '"+ Id +"'");
                DatabaseCart myDB = new DatabaseCart(CartActivity.this);
                myDB.deleteOneRow(Id);
                updateCartList();
                totalPrice();

            }
        });

        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialogXoa.show();
    }
    private void updateCartList(){
        // get all data from sqlite
        //Cursor cursor = MenuDetailActivity.databaseCart.getData("SELECT * FROM CART");
        Cursor cursor = myDB.readAllData();
        cartArrayList.clear();
        while (cursor.moveToNext()) {

            String nameCart = cursor.getString(1);
            Double priceCart= cursor.getDouble(2);
            int numberCart= cursor.getInt(3);
            Double totalCart= cursor.getDouble(4);
            int id = cursor.getInt(0);
            //byte[] imagedetail = cursor.getBlob(3);
            cartArrayList.add(new Cart(id, nameCart, priceCart,numberCart,totalCart)); }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_cart_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mn_Hompage){

            Intent intent = new Intent (CartActivity.this,TrangChu.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}