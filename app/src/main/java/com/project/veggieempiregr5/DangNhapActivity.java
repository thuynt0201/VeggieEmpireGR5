package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.BaseActivity;
import com.project.CommonUtils;
import com.project.Utils.Utils;
import com.project.database.SQLiteHelper;
import com.project.models.Voucher;
import com.project.retrofit.ApiBanHang;
import com.project.retrofit.RetrofitClient;
import com.project.viewmodel.LoginViewModel;

import java.util.List;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DangNhapActivity extends BaseActivity<LoginViewModel> implements View.OnClickListener {
    private Button btn_dangnhap,btn_dangky;
    private TextView tv_quenmk;
    private EditText username,password;
    private FirebaseAuth mAuth;
    private SQLiteHelper db;

    @Override
    protected Class<LoginViewModel> getClassViewModel() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_dang_nhap;
    }

    @Override
    protected void initViews() {
        tv_quenmk=findViewById(R.id.tv_quenmatkhau);
        findViewById(R.id.btn_dangnhap).setOnClickListener(this);
        findViewById(R.id.btn_dangky).setOnClickListener(this);
        db = new SQLiteHelper(this);
        username = findViewById(R.id.ed_username);
        password = findViewById(R.id.ed_password);
        mModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Intent intent = new Intent(DangNhapActivity.this, TrangChu.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dangnhap:
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(this, "Vui lòng nhập tên tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
                }else{
                    signInUser(user,pass);
                }
                break;
             // forNonFireBase();
             //   break;
            case R.id.btn_dangky:
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                List<Voucher> voucherList = CommonUtils.getInstance().convertListVoucher(
                        CommonUtils.getInstance().getJsonStore(R.raw.voucher));
                //  Log.i("KMFG", "onCreateView: "+voucherList.toString());
                for (int i = 0; i < voucherList.size(); i++) {
                    db.addVoucher(voucherList.get(i));
                }
                startActivity(intent);
                break;
        }
    }

    private void forNonFireBase() {
        List<Voucher> voucherList = CommonUtils.getInstance().convertListVoucher(
                CommonUtils.getInstance().getJsonStore(R.raw.voucher));
        //  Log.i("KMFG", "onCreateView: "+voucherList.toString());
        for (int i = 0; i < voucherList.size(); i++) {
            db.addVoucher(voucherList.get(i));
        }
        Intent i = new Intent(this, TrangChu.class);
        startActivity(i);
        finish();
    }

    private void signInUser(String email,String password){
        List<Voucher> voucherList = CommonUtils.getInstance().convertListVoucher(
                CommonUtils.getInstance().getJsonStore(R.raw.voucher));
      //  Log.i("KMFG", "onCreateView: "+voucherList.toString());
        for (int i = 0; i < voucherList.size(); i++) {
            db.addVoucher(voucherList.get(i));
        }
        mModel.signIn(email, password);
    }

}
