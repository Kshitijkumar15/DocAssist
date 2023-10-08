package com.example.doctor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class Dashboard extends AppCompatActivity {
        AlertDialog.Builder builder;
        private FirebaseAuth firebaseAuth;
        private ImageView mmenupopupbutton;
        private TextView mAppointments,minpatient,moutpatient,mpatienthandover,mlogout;
        RecyclerView mrecylerview;

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
        firebaseAuth = FirebaseAuth.getInstance();
        mmenupopupbutton=findViewById(R.id.menupopupbutton);

            setContentView(R.layout.activity_dashboard);
            Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);

        mAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Appointments.class);
                v.getContext().startActivity( intent);

            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(Dashboard.this, MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
    public void signOut(){
        startActivity(new Intent(Dashboard.this, MainActivity.class));
    }

    //    public boolean onOptionsItemSelected(@NonNull menu item) {
//            firebaseAuth.signOut();
//            finish();
//            startActivity(new Intent(Dashboard.this, MainActivity.class));
//            return false;
//        }
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
