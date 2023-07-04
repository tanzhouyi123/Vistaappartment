package com.example.vistaappartment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CaptureVisitorInfoActivity extends AppCompatActivity {

    private EditText editTextVisitorName;
    private EditText editTextNumberPlate;
    private EditText editTextHouseToVisit;
    private Button buttonCaptureVisitorInfo;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capture_visitor_info);

        editTextVisitorName = findViewById(R.id.editTextVisitorName);
        editTextNumberPlate = findViewById(R.id.editTextCarNumberPlate);
        editTextHouseToVisit = findViewById(R.id.editTextHouseToVisit);
        buttonCaptureVisitorInfo = findViewById(R.id.buttonCaptureVisitorInfo);

        databaseHelper = new DatabaseHelper(this);

        buttonCaptureVisitorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String visitorName = editTextVisitorName.getText().toString();
                String numberPlate = editTextNumberPlate.getText().toString();
                String houseToVisit = editTextHouseToVisit.getText().toString();

                // Save visitor info to the database
                long insertedRowId = saveVisitorInfo(visitorName, numberPlate, houseToVisit);

                if (insertedRowId != -1) {
                    Toast.makeText(CaptureVisitorInfoActivity.this, "Visitor info saved to database", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CaptureVisitorInfoActivity.this, "Failed to save visitor info", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private long saveVisitorInfo(String name, String numberPlate, String houseToVisit) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_NUMBER_PLATE, numberPlate);
        values.put(DatabaseHelper.COLUMN_HOUSE_TO_VISIT, houseToVisit);

        return db.insert(DatabaseHelper.TABLE_VISITORS, null, values);
    }

}
