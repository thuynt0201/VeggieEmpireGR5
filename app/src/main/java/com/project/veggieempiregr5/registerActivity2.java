package com.project.veggieempiregr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.project.database.Database;
import com.project.veggieempiregr5.databinding.ActivityRegister2Binding;

public class registerActivity2 extends AppCompatActivity {
    ActivityRegister2Binding binding;
    EditText phone, password, confirmpass;
    Database DB;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googlebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_register2);

        binding = ActivityRegister2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        confirmpass = findViewById(R.id.confirmpass);

        laodData();

        DB = new Database(this);


        //login bằng email
        googlebtn = findViewById(R.id.googlebtn);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singIn();
            }
        });



    }

    private void singIn() {
        Intent sinInIntent = gsc.getSignInIntent();
        startActivityForResult(sinInIntent,1000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Đã xảy ra sự cố", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(registerActivity2.this,SecondActivity2.class);
        startActivity(intent);
    }



    private void laodData() {


        binding.txtdn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent=new Intent(registerActivity2.this,loginActivity2.class);
                startActivity(intent);
            }
        });

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = phone.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmpass.getText().toString();


                if(user.equals("") || pass.equals("") || confirm.equals(""))
                    Toast.makeText(registerActivity2.this, "Vui lòng hãy điền tất cả thông tin" , Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(confirm)) {
                        Boolean checkuser = DB.checkphone(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData (user, pass);
                            if (insert == true) {
                                Toast.makeText(registerActivity2.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), loginActivity2.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(registerActivity2.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(registerActivity2.this, "Người dùng đã tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(registerActivity2.this, "Mật khẩu của bạn không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}