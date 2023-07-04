package com.example.vistaappartment;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

public class EnterResidentAccountInfoActivity extends AppCompatActivity {

    public void saveResidentAccountInfo(String name, String phoneNumber, String email, String houseNumber) {
        // Perform the necessary actions to save the resident account information

        // For example, you can store the data in a database
        DatabaseHelper dbHelper = new DatabaseHelper(context); // Replace 'context' with the appropriate context reference
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_PHONE_NUMBER, phoneNumber);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_HOUSE_NUMBER, houseNumber);

        long newRowId = db.insert(DatabaseHelper.TABLE_RESIDENTS, null, values);
        if (newRowId != -1) {
            // Successful insertion
            Toast.makeText(context, "Resident account saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            // Error occurred during insertion
            Toast.makeText(context, "Failed to save resident account", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

}
