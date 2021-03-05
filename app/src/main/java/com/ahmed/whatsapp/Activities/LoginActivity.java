package com.ahmed.whatsapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ahmed.whatsapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
FirebaseAuth fAuth;
EditText et_Email,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fAuth=FirebaseAuth.getInstance();
        et_Email=findViewById(R.id.Login_et_Email);
        et_password=findViewById(R.id.Login_et_Password);

    }

    public void CreateAnAccount(View view) {
        startActivity(new Intent(getBaseContext(),RegisterActivity.class));
    }

    public void Login(View view) {
        fAuth.signInWithEmailAndPassword(et_Email.getText().toString(),et_password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "failed operation.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}