package com.example.vistaappartment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardFunction;
    private Button btnApartmentManagerFunction;
    private Button btnResident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons by their IDs
        btnGuardFunction = findViewById(R.id.BtnGuardFunction);
        btnApartmentManagerFunction = findViewById(R.id.BtnApartmentManagerFunction);
        btnResident = findViewById(R.id.BtnResident);

        // Set click listeners for each button
        btnGuardFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Guard Function page
                Intent intent = new Intent(MainActivity.this, GuardFunctionActivity.class);
                startActivity(intent);
            }
        });

        btnApartmentManagerFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Apartment Manager Function page
                Intent intent = new Intent(MainActivity.this, ApartmentManagerActivity.class);
                startActivity(intent);
            }
        });

        btnResident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Resident page
                Intent intent = new Intent(MainActivity.this, ResidentActivity.class);
                startActivity(intent);
            }
        });
    }
}