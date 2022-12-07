package com.project.veggieempiregr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.database.Database;

public class ConfirmpassActivity2 extends AppCompatActivity {

    EditText password, repassword;
    Button btnconfirm;
    ImageView imvback;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmpass2);

        DB = new Database(this);

        password = (EditText) findViewById(R.id.pass);
        repassword = (EditText) findViewById(R.id.repass);
        btnconfirm = (Button) findViewById(R.id.btnconfirm);
        imvback = (ImageView) findViewById(R.id.imvback);

        Intent intent = getIntent();


        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String repass = repassword.getText().toString();
                String pass = password.getText().toString();

                if(pass.equals(repass)) {
                    Boolean checkuserpasswordupdate = DB.updatepassword(pass);

                    if (checkuserpasswordupdate == true) {
                        Toast.makeText(ConfirmpassActivity2.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), loginActivity2.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ConfirmpassActivity2.this, "Không cập nhật mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ConfirmpassActivity2.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
                }
            });
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmpassActivity2.this, loginActivity2.class);
                startActivity(intent);
            }
        });


        }

    }
