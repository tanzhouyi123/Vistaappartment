package com.example.vistaappartment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class VisitorReportActivity extends AppCompatActivity {
    private TextView tvVisitorReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_visitor_report);

        tvVisitorReport = findViewById(R.id.tv_visitor_report);

        // Sample visitor data
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor(1, "John Doe", "ABC123", "Apartment 101"));
        visitors.add(new Visitor(2, "Jane Smith", "XYZ789", "Apartment 202"));

        // Generate visitor report
        String report = Visitor.generateVisitorReport(visitors);

        // Display the report in the TextView
        tvVisitorReport.setText(report);
    }
}
