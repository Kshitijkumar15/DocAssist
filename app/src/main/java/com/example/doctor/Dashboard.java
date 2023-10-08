package com.example.doctor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class Dashboard extends AppCompatActivity {
        AlertDialog.Builder builder;
        FloatingActionButton mcreatenotesfab;
        private FirebaseAuth firebaseAuth;
        private TextView mAppointments,minpatient,moutpatient,mpatienthandover;
        RecyclerView mrecylerview;
        StaggeredGridLayoutManager staggeredGridLayoutManager;

        FirebaseUser firebaseUser;
        FirebaseFirestore firebaseFirestore;
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAppointments =findViewById(R.id.Appointments);
        minpatient =findViewById(R.id.inpatient);
        moutpatient =findViewById(R.id.outpatient);
        mpatienthandover =findViewById(R.id.patienthandover);
//        Toolbar toolbar = findViewById(R.id.toolbarofdoctor);
//        setSupportActionBar(toolbar);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        mAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Appointments.class);
                v.getContext().startActivity( intent);

            }
        });

    }
//    protected void onBindViewHolder() {
//        ImageView popup = findViewById(R.id.menupopupbutton);
//        popup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
//                popupMenu.setGravity(Gravity.END);
//                Intent intent = new Intent(v.getContext(), MainActivity.class);
//                v.getContext().startActivity(intent);
////
//            }
//        });
//    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(Dashboard.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        builder.setTitle("Quit");
        builder.setMessage("Do you really want to quit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
