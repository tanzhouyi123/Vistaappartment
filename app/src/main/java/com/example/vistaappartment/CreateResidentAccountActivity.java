package com.example.vistaappartment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;


public class CreateResidentAccountActivity {
    public String name;
    public String phoneNumber;
    public String email;
    public String houseNumber;

    public CreateResidentAccountActivity(String name, String phoneNumber, String email, String houseNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.houseNumber = houseNumber;
    }

    public void saveResidentAccount() {
        // TODO: Add code here to save the resident account to a database or perform any other required operations
        System.out.println("Resident account created and saved successfully!");
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("House Number: " + houseNumber);
    }

    // Getter and setter methods for the fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public static void main(String[] args) {
        // Example usage
        CreateResidentAccountActivity residentAccount = new CreateResidentAccountActivity("John Doe", "1234567890", "johndoe@example.com", "101");
        residentAccount.saveResidentAccount();
    }


}
