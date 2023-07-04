package com.example.vistaappartment;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    private int id;
    private String name;
    private String numberPlate;
    private String houseToVisit;

    // Constructor
    public Visitor(int id, String name, String numberPlate, String houseToVisit) {
        this.id = id;
        this.name = name;
        this.numberPlate = numberPlate;
        this.houseToVisit = houseToVisit;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getHouseToVisit() {
        return houseToVisit;
    }

    // Generate visitor report
    public static String generateVisitorReport(List<Visitor> visitors) {
        StringBuilder report = new StringBuilder();

        for (Visitor visitor : visitors) {
            report.append("Visitor ID: ").append(visitor.getId()).append("\n");
            report.append("Name: ").append(visitor.getName()).append("\n");
            report.append("Number Plate: ").append(visitor.getNumberPlate()).append("\n");
            report.append("House to Visit: ").append(visitor.getHouseToVisit()).append("\n");
            report.append("\n");
        }

        return report.toString();
    }

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
}
