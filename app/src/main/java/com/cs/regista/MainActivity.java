package com.cs.regista;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<StudentInfo> studentInfos = new ArrayList<>();

    EditText student_name;
    EditText student_roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.main_fab);
        //Toolbar
        setSupportActionBar(toolbar);
        //Navigation Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_bar_open, R.string.nav_bar_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Dialogue for main floating action button
        fab.setOnClickListener(v -> showDialog());

        //Recycler View
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Stduent Adapter
        studentAdapter = new StudentAdapter(this,studentInfos);
        recyclerView.setAdapter(studentAdapter);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.student_dialog, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        //Edit text
        student_name = view.findViewById(R.id.student_name);
        student_roll = view.findViewById(R.id.student_roll);

        //Buttons
        Button cancel = view.findViewById(R.id.s_button_cancel);
        Button add = view.findViewById(R.id.s_button_add);

        //When the cancel button is pressed
        cancel.setOnClickListener(v-> dialog.dismiss());

        //When the add button is pressed
        add.setOnClickListener(v-> {
            addStudent();
            dialog.dismiss();
        });


    }

    private void addStudent() {
        String studentName = student_name.getText().toString();
        String studentRoll = student_roll.getText().toString();
        studentInfos.add(new StudentInfo(studentName,studentRoll));
        studentAdapter.notifyDataSetChanged();
    }
}