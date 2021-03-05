package com.ahmed.whatsapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.ahmed.whatsapp.Adapters.TablayoutAdapter;
import com.ahmed.whatsapp.R;
import com.ahmed.whatsapp.model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    TablayoutAdapter tablayoutAdapter;
    FirebaseUser firebaseUser;
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindView();
        ActionBarSettings();
        intial();
        configureTablayout();
        fAuth=FirebaseAuth.getInstance();
        firebaseUser=fAuth.getCurrentUser();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("whatsapp").child("users").
                child(firebaseUser.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user=(User) snapshot.getChildren();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        Toast.makeText(this, firebaseUser.getUid(), Toast.LENGTH_SHORT).show();

    }

    private void configureTablayout() {
        viewPager.setAdapter(tablayoutAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void intial() {
        tablayoutAdapter=new TablayoutAdapter(getSupportFragmentManager());
    }

    private void ActionBarSettings() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Whatsapp");
    }

    private void BindView() {
        toolbar = findViewById(R.id.MenuToolbar);
        viewPager=findViewById(R.id.MenuViewPager);
        tabLayout=findViewById(R.id.MenuTablayout);
    }
}