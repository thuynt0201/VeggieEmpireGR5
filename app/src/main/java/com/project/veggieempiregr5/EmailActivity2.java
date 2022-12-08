package com.project.veggieempiregr5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class EmailActivity2 extends AppCompatActivity {
    ProgressBar progressBar;
    EditText edtuserEmail;
    Button btnForgotPass;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email2);
        //======THANH HEADER======
        getSupportActionBar().setTitle("VEGGIE EMPIRE");
        //======THANH HEADER END======

        ImageView imvback = findViewById(R.id.imvback);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        edtuserEmail = findViewById(R.id.edtUserEmail);
        btnForgotPass = findViewById(R.id.btnForgotPass);

        firebaseAuth = FirebaseAuth.getInstance();
        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(edtuserEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        progressBar.setVisibility(View.GONE);
                        
                        if(task.isSuccessful()){
                            Toast.makeText(EmailActivity2.this, "Mật khẩu đã đucợ gửi qua email", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(EmailActivity2.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                        
                    }
                });
            }
        });





        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmailActivity2.this, loginActivity2.class);
                startActivity(intent);
            }
        });

    }
}