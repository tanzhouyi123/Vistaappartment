package com.example.vistaappartment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
//import com.example.vistaappartment.Visitor;
import java.util.ArrayList;
import java.util.List;

public class GenerateVisitorReportActivity extends AppCompatActivity {
    private TextView tvVisitorReport;
    public static void main(String[] args) {
        // Sample visitor data
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor(1, "John Doe", "ABC123", "Apartment 101"));
        visitors.add(new Visitor(2, "Jane Smith", "XYZ789", "Apartment 202"));

        // Generate visitor report
        String report = Visitor.generateVisitorReport(visitors);

        // Print the report
        System.out.println(report);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_visitor_report);

        tvVisitorReport = findViewById(R.id.tv_visitor_report);

        // Retrieve visitor data from the database or any other source
        List<Visitor> visitors = getVisitorData();

        // Generate visitor report
        String visitorReport = generateVisitorReport(visitors);

        // Display the visitor report in the TextView
        tvVisitorReport.setText(visitorReport);
    }

    private List<Visitor> getVisitorData() {
        // Retrieve visitor data from the database or any other source
        // and return a List<Visitor> object
        // Implement your own logic here
        return null;
    }

    private String generateVisitorReport(List<Visitor> visitors) {
        StringBuilder report = new StringBuilder();

        if (visitors != null && !visitors.isEmpty()) {
            for (Visitor visitor : visitors) {
                report.append("Visitor ID: ").append(visitor.getId()).append("\n");
                report.append("Name: ").append(visitor.getName()).append("\n");
                report.append("Number Plate: ").append(visitor.getNumberPlate()).append("\n");
                report.append("House to Visit: ").append(visitor.getHouseToVisit()).append("\n");
                report.append("\n");
            }
        } else {
            report.append("No visitors found.");
        }

        return report.toString();
    }

    }

