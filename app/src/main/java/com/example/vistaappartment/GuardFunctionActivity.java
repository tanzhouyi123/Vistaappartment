package com.example.vistaappartment;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GuardFunctionActivity extends AppCompatActivity {

    private Button captureVisitorInfoButton;
    private Button timeInButton;
    private Button timeOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guard_function);

        // Find buttons by their IDs
        captureVisitorInfoButton = findViewById(R.id.btnCaptureVisitorInfo);
        timeInButton = findViewById(R.id.buttonTimeIn);
        timeOutButton = findViewById(R.id.buttonTimeOut);

        // Set click listeners for each button
        captureVisitorInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Capture Visitor Info activity
                Intent intent = new Intent(GuardFunctionActivity.this, CaptureVisitorInfoActivity.class);
                startActivity(intent);
            }
        });

        timeInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Capture Time In activity
                Intent intent = new Intent(GuardFunctionActivity.this, CaptureTimeActivity.class);
                startActivity(intent);
            }
        });

        timeOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Capture Time Out activity
                Intent intent = new Intent(GuardFunctionActivity.this, CaptureTimeActivity.class);
                startActivity(intent);
            }
        });
    }
}
