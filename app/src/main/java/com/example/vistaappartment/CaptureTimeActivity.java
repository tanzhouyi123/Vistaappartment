package com.example.vistaappartment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
public class CaptureTimeActivity {


        private static final String DB_NAME = "VisitorDB";
        private static final int DB_VERSION = 1;
        private static final String TABLE_NAME = "Visitors";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_CONTACT_INFO = "contact_info";
        private static final String COL_PURPOSE = "purpose";
        private static final String COL_TIME_IN = "time_in";
        private static final String COL_TIME_OUT = "time_out";
        private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_CONTACT_INFO + " TEXT, " +
                COL_PURPOSE + " TEXT, " +
                COL_TIME_IN + " TEXT, " +
                COL_TIME_OUT + " TEXT);";

        private SimpleDateFormat dateFormat;
        private DatabaseHelper dbHelper;

        public CaptureTimeActivity(Context context) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dbHelper = new DatabaseHelper(context);
        }

        public void CaptureVisitorInfo(String visitorName, String contactInfo, String purposeOfVisit) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(COL_NAME, visitorName);
            values.put(COL_CONTACT_INFO, contactInfo);
            values.put(COL_PURPOSE, purposeOfVisit);

            // Insert visitor data into the database
            long visitorId = db.insert(TABLE_NAME, null, values);

            db.close();
        }

        public String recordTimeIn() {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Get the current time
            Date currentTime = new Date();
            String timeIn = dateFormat.format(currentTime);

            ContentValues values = new ContentValues();
            values.put(COL_TIME_IN, timeIn);

            // Update the most recent visitor's time in
            db.update(TABLE_NAME, values, COL_ID + " = (SELECT MAX(" + COL_ID + ") FROM " + TABLE_NAME + ")", null);

            db.close();

            return timeIn;
        }

        public void recordTimeOut() {
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Get the current time
            Date currentTime = new Date();
            String timeOut = dateFormat.format(currentTime);

            ContentValues values = new ContentValues();
            values.put(COL_TIME_OUT, timeOut);

            // Update the most recent visitor's time out
            db.update(TABLE_NAME, values, COL_ID + " = (SELECT MAX(" + COL_ID + ") FROM " + TABLE_NAME + ")", null);

            db.close();
        }

        private static class DatabaseHelper extends SQLiteOpenHelper {
            DatabaseHelper(Context context) {
                super(context, DB_NAME, null, DB_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_TABLE_QUERY);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // Drop the existing table if needed and recreate it
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(db);
            }
        }
    }


