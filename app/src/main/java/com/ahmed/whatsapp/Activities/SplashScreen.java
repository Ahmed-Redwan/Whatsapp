package com.ahmed.whatsapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ahmed.whatsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    FirebaseUser currentuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        currentuser = FirebaseAuth.getInstance().getCurrentUser();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentuser == null) {
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                }
                finish();
            }
        }, 5000);

    }
}