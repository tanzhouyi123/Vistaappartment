package com.example.vistaappartment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GeneratePaymentRecordActivity extends AppCompatActivity {

    private Button generateRecordButton;
    private Button sendReminderButton;
    private TextView paymentRecordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_payment_record);

        generateRecordButton = findViewById(R.id.generate_record_button);
        sendReminderButton = findViewById(R.id.send_reminder_button);
        paymentRecordTextView = findViewById(R.id.payment_record_textview);

        generateRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paymentRecord = generatePaymentRecord();
                paymentRecordTextView.setText(paymentRecord);
            }
        });

        sendReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendReminderToResidents();
            }
        });
    }

    private void sendReminderToResidents() {
        // Implement the logic to send payment reminders to residents here
        // You can use various communication methods like email, SMS, or push notifications
        // Access the resident data from the database or any other data source

        // Example implementation using Toast message
        Toast.makeText(this, "Reminder sent to residents", Toast.LENGTH_SHORT).show();
    }

    private String generatePaymentRecord() {
        // Query payment data from the database and calculate totals
        List<Payment> payments = getPaymentDataFromDatabase();
        double totalAmountPaid = calculateTotalAmountPaid(payments);

        // Format the payment record as a string
        StringBuilder paymentRecord = new StringBuilder();
        paymentRecord.append("Payment Record\n\n");
        paymentRecord.append("Total Amount Paid: $").append(totalAmountPaid).append("\n\n");
        paymentRecord.append("Payment Details:\n");
        for (Payment payment : payments) {
            paymentRecord.append("Date: ").append(payment.getDate()).append("\n");
            paymentRecord.append("Amount: $").append(payment.getAmount()).append("\n");
            paymentRecord.append("Description: ").append(payment.getDescription()).append("\n\n");
        }

        // Return the generated payment record as a string
        return paymentRecord.toString();
    }

    private List<Payment> getPaymentDataFromDatabase() {
        List<Payment> payments = new ArrayList<>();

        // Retrieve payment data from the database
        // Replace this with your actual database query
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_PAYMENTS,
                null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve payment data from the cursor
                int paymentIdIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PAYMENT_ID);
                int dateIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE);
                int amountIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_AMOUNT);
                int descriptionIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_DESCRIPTION);

                // Check if the column indexes are valid
                if (paymentIdIndex != -1 && dateIndex != -1 && amountIndex != -1 && descriptionIndex != -1) {
                    int paymentId = cursor.getInt(paymentIdIndex);
                    String date = cursor.getString(dateIndex);
                    double amount = cursor.getDouble(amountIndex);
                    String description = cursor.getString(descriptionIndex);

                    // Create a Payment object with the retrieved data
                    Payment payment = new Payment(paymentId, date, amount, description);

                    // Add the Payment object to the list
                    payments.add(payment);
                }
            } while (cursor.moveToNext());

            // Close the cursor after retrieving data
            cursor.close();
        }

        // Close the database connection
        db.close();

        // Return the list of Payment objects
        return payments;
    }

    private double calculateTotalAmountPaid(List<Payment> payments) {
        double totalAmountPaid = 0.0;

        // Iterate through the list of payments and calculate the total amount paid
        for (Payment payment : payments) {
            totalAmountPaid += payment.getAmount();
        }

        return totalAmountPaid;
    }
}
