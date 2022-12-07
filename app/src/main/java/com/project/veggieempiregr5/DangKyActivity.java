package com.project.veggieempiregr5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;
import com.project.BaseActivity;
import com.project.CommonUtils;
import com.project.database.SQLiteHelper;
import com.project.models.Voucher;
import com.project.retrofit.ApiBanHang;
import com.project.retrofit.RetrofitClient;
import com.project.Utils.Utils;
import com.project.Utils.Utils;
import com.project.viewmodel.SignUpViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DangKyActivity extends BaseActivity<SignUpViewModel> implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView tv_quaylaidn;
    private EditText edtEmail, edtPassword, edtName, edtRePassword;

    @Override
    protected Class<SignUpViewModel> getClassViewModel() {
        return SignUpViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_dang_ky;
    }

    @Override
    protected void initViews() {
        mAuth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.edt_email);
        edtRePassword = findViewById(R.id.edt_repassword);
        edtName = findViewById(R.id.edt_name);
        edtPassword = findViewById(R.id.edt_password);
        tv_quaylaidn=findViewById(R.id.tv_quaylaidn_register);
        findViewById(R.id.btn_dangky).setOnClickListener(this);
        mModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null){
                  //  makeToast("User " +  firebaseUser.getEmail() + " has been created");
                    gotoSignInAct();
                }
            }
        });
    }

    private void gotoSignInAct() {
        Intent intent = new Intent(this, DangNhapActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dangky:
                String user = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String pass = edtPassword.getText().toString();
                String repass = edtRePassword.getText().toString();
                if (user.equals("") || email.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(this, "Vui lòng điền vào tất cả thông tin", Toast.LENGTH_LONG).show();
                } else {
//                    Intent intent = new Intent(this, TrangChu.class);
//                    startActivity(intent);
//                    finish();
                   mModel.handleSignUp(email, pass, user);

                }
                break;
            case R.id.tv_quaylaidn_register:
                onBackPressed();
                break;
        }

    }

}
