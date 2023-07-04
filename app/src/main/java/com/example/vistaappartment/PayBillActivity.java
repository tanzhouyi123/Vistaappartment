package com.example.vistaappartment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PayBillActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private EditText editTextCardNumber;
    private EditText editTextCardExpiry;
    private EditText editTextCardCVV;
    private Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_bill);

        // Initialize views
        editTextAmount = findViewById(R.id.editTextAmount);
        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextCardExpiry = findViewById(R.id.editTextCardExpiry);
        editTextCardCVV = findViewById(R.id.editTextCardCVV);
        buttonPay = findViewById(R.id.buttonPay);

        // Set click listener for pay button
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payBill();
            }
        });
    }

    private void payBill() {
        // Get the entered payment details
        String amount = editTextAmount.getText().toString().trim();
        String cardNumber = editTextCardNumber.getText().toString().trim();
        String cardExpiry = editTextCardExpiry.getText().toString().trim();
        String cardCVV = editTextCardCVV.getText().toString().trim();

        // Validate the payment details
        if (amount.isEmpty() || cardNumber.isEmpty() || cardExpiry.isEmpty() || cardCVV.isEmpty()) {
            Toast.makeText(this, "Please enter all payment details", Toast.LENGTH_SHORT).show();
        } else {
            // TODO: Process the payment and update the payment status
            // Get the entered payment details
            String amount = editTextAmount.getText().toString().trim();
            String cardNumber = editTextCardNumber.getText().toString().trim();
            String cardExpiry = editTextCardExpiry.getText().toString().trim();
            String cardCVV = editTextCardCVV.getText().toString().trim();

            // Validate the payment details
            if (amount.isEmpty() || cardNumber.isEmpty() || cardExpiry.isEmpty() || cardCVV.isEmpty()) {
                Toast.makeText(this, "Please enter all payment details", Toast.LENGTH_SHORT).show();
            } else {
                // Process the payment and update the payment status
                boolean paymentSuccess = processPayment(amount, cardNumber, cardExpiry, cardCVV);

                if (paymentSuccess) {
                    // Payment successful
                    Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();

                    // Clear the input fields
                    editTextAmount.setText("");
                    editTextCardNumber.setText("");
                    editTextCardExpiry.setText("");
                    editTextCardCVV.setText("");
                } else {
                    // Payment failed
                    Toast.makeText(this, "Payment failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }

            // Show a success message
            Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();

            // Clear the input fields
            editTextAmount.setText("");
            editTextCardNumber.setText("");
            editTextCardExpiry.setText("");
            editTextCardCVV.setText("");
        }
    }
}
