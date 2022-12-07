package com.project.veggieempiregr5;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.project.database.Database;
import com.project.veggieempiregr5.databinding.ActivityLogin2Binding;

public class loginActivity2 extends AppCompatActivity {
   ActivityLogin2Binding binding;
    EditText phone, password;
    Database DB;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googlebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login2);

        //======THANH HEADER======
        getSupportActionBar().setTitle("VEGGIE EMPIRE");
        //======THANH HEADER END======


        binding = ActivityLogin2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        loadData();
        DB = new Database(this);


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
        Intent intent = new Intent(loginActivity2.this,SecondActivity2.class);
        startActivity(intent);
    }


    private void loadData() {

        binding.txtdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity2.this, registerActivity2.class);
                startActivity(intent);
            }
        });


        //login
        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = phone.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(loginActivity2.this, "Vui lòng điền hết tất cả thông tin", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpassword = DB.checkpassword(user, pass);
                    if (checkuserpassword == true) {
                        Toast.makeText(loginActivity2.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TrangChu.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(loginActivity2.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    public void quenmk_click(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.forget_layout,null);


        Button btnsms = (Button) dialogView.findViewById(R.id.btnsms);
        Button btntkemail = (Button) dialogView.findViewById(R.id.btntkemail);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity2.this, SMSActivity2.class);
                startActivity(intent);
            }
        });
        btntkemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity2.this, EmailActivity2.class);
                startActivity(intent);
            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle("Bạn muốn đổi mật khẩu bằng phương thức nào ?");
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}







