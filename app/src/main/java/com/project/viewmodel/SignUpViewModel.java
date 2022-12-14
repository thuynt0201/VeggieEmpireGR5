package com.project.viewmodel;

import android.net.Uri;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.project.Constants;
import com.project.models.User;

public class SignUpViewModel extends BaseViewModel{

    private MutableLiveData<FirebaseUser> userMutableLiveData;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    public SignUpViewModel() {
        userMutableLiveData = new MutableLiveData<>();

    }

    public void signUp(String email, String password, String name, String cPassword, Uri imageUri){
        if (!password.equals(cPassword)){
            errorMessage.postValue("Password and confirm password must be the same");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            errorMessage.postValue("Please enter valid email");
        } else  if (email.trim().isEmpty() || name.trim().isEmpty() || password.trim().isEmpty() || cPassword.trim().isEmpty()) {
            errorMessage.postValue("Please fill out the form");
        } else {
            handleSignUp(email, password, name);
        }
    }

    public void handleSignUp(String email, String password, String name){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            databaseReference = firebaseDatabase.getReference().child("users-reg").child(firebaseAuth.getUid());
                            upUserToDatabase(firebaseAuth.getUid(), name, email);

                        } else {
                            errorMessage.postValue(task.getException().toString());
                        }
                    }
                });
    }

    public void upUserToDatabase(String uid, String name, String email){
        User user = new User(uid, name, email, Constants.OFFLINE);
        databaseReference.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                } else {
                    errorMessage.postValue(task.getException().toString());
                }
            }
        });
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }


}
