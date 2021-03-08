package com.ahmed.whatsapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ahmed.whatsapp.R;
import com.ahmed.whatsapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth fAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    EditText et_name, et_email, et_phone, et_password, et_confirmPAssword;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("whatsapp");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_email = findViewById(R.id.register_et_Email);
        et_password = findViewById(R.id.register_et_Password);
        et_phone = findViewById(R.id.register_et_Phone);
        et_name = findViewById(R.id.register_et_UserName);
        et_confirmPAssword = findViewById(R.id.register_et_ConfirmPassword);
        fAuth = FirebaseAuth.getInstance();


    }

    public void Register(View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "Please wait", "Processing", true);
        fAuth.createUserWithEmailAndPassword(et_email.getText().toString(), et_password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_SHORT).show();
                            myRef.child("users").child(fAuth.getCurrentUser().getUid()).child("personal information").setValue(new User(
                                    et_email.getText().toString(), et_name.getText().toString(), et_phone.getText().toString(), ""));

                        } else {

                        }
                        progressDialog.dismiss();
                    }
                });
    }

    public void openLoginActivity(View view) {
    }
}