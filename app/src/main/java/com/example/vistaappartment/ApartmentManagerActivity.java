package com.example.vistaappartment;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ApartmentManagerActivity extends AppCompatActivity {

    private Button generateVisitorReportButton;
    private Button createResidentAccountButton;
    private Button searchResidentInfoButton;
    private Button generatePaymentRecordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apartment_manager_function);

        // Find buttons by their IDs
        generateVisitorReportButton = findViewById(R.id.generateVisitorReportButton);
        createResidentAccountButton = findViewById(R.id.createResidentAccountButton);
        searchResidentInfoButton = findViewById(R.id.searchResidentInfoButton);
        generatePaymentRecordButton = findViewById(R.id.generatePaymentRecordButton);

        // Set click listeners for each button
        generateVisitorReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Generate Visitor Report activity
                Intent intent = new Intent(ApartmentManagerActivity.this, GenerateVisitorReportActivity.class);
                startActivity(intent);
            }
        });

        createResidentAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Create Resident Account activity
                Intent intent = new Intent(ApartmentManagerActivity.this, CreateResidentAccountActivity.class);
                startActivity(intent);
            }
        });

        searchResidentInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Search Resident Info activity
                Intent intent = new Intent(ApartmentManagerActivity.this, SearchResidentInfoActivity.class);
                startActivity(intent);
            }
        });

        generatePaymentRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Generate Payment Record activity
                Intent intent = new Intent(ApartmentManagerActivity.this, GeneratePaymentRecordActivity.class);
                startActivity(intent);
            }
        });
    }
}
