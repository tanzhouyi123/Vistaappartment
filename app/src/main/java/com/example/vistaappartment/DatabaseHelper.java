package com.example.vistaappartment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "vista_apartment.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_VISITORS = "visitors";
    public static final String TABLE_RESIDENTS = "residents";
    public static final String TABLE_PAYMENTS = "payments";

    // Common column names
    public static final String COLUMN_ID = "id";

    // Visitors table column names
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUMBER_PLATE = "number_plate";
    public static final String COLUMN_HOUSE_TO_VISIT = "house_to_visit";
    public static final String COLUMN_TIME_IN = "time_in";
    public static final String COLUMN_TIME_OUT = "time_out";

    // Residents table column names
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_HOUSE_NUMBER = "house_number";

    // Payments table column names
    public static final String COLUMN_PAYMENT_ID = "payment_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_DESCRIPTION = "description";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create visitors table
        String createVisitorsTableQuery = "CREATE TABLE " + TABLE_VISITORS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_NUMBER_PLATE + " TEXT, " +
                COLUMN_HOUSE_TO_VISIT + " TEXT, " +
                COLUMN_TIME_IN + " TEXT, " +
                COLUMN_TIME_OUT + " TEXT" +
                ")";
        db.execSQL(createVisitorsTableQuery);

        // Create residents table
        String createResidentsTableQuery = "CREATE TABLE " + TABLE_RESIDENTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHONE_NUMBER + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_HOUSE_NUMBER + " TEXT" +
                ")";
        db.execSQL(createResidentsTableQuery);

        // Create payments table
        String createPaymentsTableQuery = "CREATE TABLE " + TABLE_PAYMENTS + "(" +
                COLUMN_PAYMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_AMOUNT + " REAL, " +
                COLUMN_DESCRIPTION + " TEXT" +
                ")";
        db.execSQL(createPaymentsTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITORS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESIDENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENTS);

        // Create new tables
        onCreate(db);
    }



}


