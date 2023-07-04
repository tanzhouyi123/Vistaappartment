package com.example.vistaappartment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchResidentInfoActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private TextView resultTextView;

    private List<String> residentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_resident_info);

        searchEditText = findViewById(R.id.editTextResidentID);
        searchButton = findViewById(R.id.buttonSearch);
        resultTextView = findViewById(R.id.textViewResidentInfo);

        residentList = new ArrayList<>();
        residentList.add("John Doe");
        residentList.add("Jane Smith");
        residentList.add("David Johnson");

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = searchEditText.getText().toString();
                searchResident(searchQuery);
            }
        });
    }

    private void searchResident(String searchQuery) {
        String result = "";

        for (String resident : residentList) {
            if (resident.toLowerCase().contains(searchQuery.toLowerCase())) {
                result += resident + "\n";
            }
        }

        if (!result.isEmpty()) {
            resultTextView.setText(result);
        } else {
            resultTextView.setText("No results found");
        }
    }
}

