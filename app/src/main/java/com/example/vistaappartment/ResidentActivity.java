package com.example.vistaappartment;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class ResidentActivity extends AppCompatActivity {

    private Button enterAccountInfoButton;
    private Button participateForumButton;
    private Button payBillButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resident);

        // Find buttons by their IDs
        enterAccountInfoButton = findViewById(R.id.enterAccountInfoButton);
        participateForumButton = findViewById(R.id.participateForumButton);
        payBillButton = findViewById(R.id.payBillButton);

        // Set click listeners for each button
        enterAccountInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Enter Account Info activity
                Intent intent = new Intent(ResidentActivity.this, EnterResidentAccountInfoActivity.class);
                startActivity(intent);
            }
        });

        participateForumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Participate in Forum activity
                Intent intent = new Intent(ResidentActivity.this, ParticipateForumActivity.class);
                startActivity(intent);
            }
        });

        payBillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Pay Bill activity
                Intent intent = new Intent(ResidentActivity.this, PayBillActivity.class);
                startActivity(intent);
            }
        });
    }
}
