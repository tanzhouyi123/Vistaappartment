package com.example.vistaappartment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ReminderActivity extends AppCompatActivity {

    private Button sendReminderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_record);

        sendReminderButton = findViewById(R.id.buttonSendReminder);

        sendReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendReminder();
            }
        });
    }

    private void sendReminder() {
        // Prepare the email intent
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reminder");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Don't forget to pay your bill!");

        // Check if there is an email client installed on the device
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent, 0);
        boolean isEmailAppInstalled = activities.size() > 0;

        if (isEmailAppInstalled) {
            // Start the email intent if an email client is available
            startActivity(Intent.createChooser(emailIntent, "Send Reminder"));
        } else {
            // Display a toast message if no email client is installed
            Toast.makeText(this, "No email client installed", Toast.LENGTH_SHORT).show();
        }
    }
}
