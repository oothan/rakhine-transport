package com.transportation.lm14.transport.DB_Handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.transportation.lm14.transport.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Maung Oo Thann on 10/21/2017.
 */

public class BusDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "transport.db";

    private static final String TABLE = "TRP";

    private static final String id = "id";
    private static final String name = "name";
    private static final String start = "start";
    private static final String end = "end";
    private static final String fprice = "fprice";
    private static final String sprice = "sprice";
    private static final String ph_no = "ph_no";
    private static final String address = "address";
    private static final String departure = "departure";
    private static final String time = "time";
    private static final String category = "category";
    private static final String favorite = "favorite";

    public BusDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE + "("
                + name + " TEXT, "
                + start + " TEXT, "
                + end + " TEXT, "
                + fprice + " TEXT, "
                + sprice + " TEXT, "
                + ph_no + " TEXT, "
                + address + " TEXT, "
                + departure + " TEXT, "
                + time + " TEXT, "
                + category + " TEXT, "
                + favorite + " TEXT, "
                + id + " TEXT PRIMARY KEY)";

        Log.i("SQL : ", CREATE_TABLE_STUDENT);

        db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed, all data will be gone!!!
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
//
//        // Create tables again
//        onCreate(db);

    }

    public void addVehicle(Vehicle vehicle) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(name, vehicle.getName());
        values.put(start, vehicle.getStart());
        values.put(end, vehicle.getEnd());
        values.put(fprice, vehicle.getFprice());
        values.put(sprice, vehicle.getSprice());
        values.put(ph_no, vehicle.getPh_no());
        values.put(address, vehicle.getAddress());
        values.put(departure, vehicle.getDeparture());
        values.put(time, vehicle.getTime());
        values.put(category, vehicle.getCategory());
        values.put(favorite, vehicle.getFavorite());
        values.put(id, vehicle.getId());

        // Inserting Row
        db.insert(TABLE, null, values);
    }

    public List<Vehicle> getAllBus(String type, String start, String end) {
        List<Vehicle> BusList = new ArrayList<Vehicle>();
        // Select All Query
        String selectQuery = "SELECT " + id + "," + name + "," + fprice + "," + sprice + ","+favorite+" FROM " + TABLE + " WHERE " + category + " = " + "'" + type + "' AND start='" + start + "' AND end='" + end + "'";
        Log.i("Query : ", selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Vehicle vehicle = new Vehicle();
                // bus.setId(Integer.parseInt(cursor.getString(0)));
                vehicle.setName(cursor.getString(1));
                vehicle.setFprice(cursor.getString(2));
                vehicle.setSprice(cursor.getString(3));
                vehicle.setId(cursor.getString(0));
                vehicle.setFavorite(cursor.getString(4));

                // Adding student to list
                BusList.add(vehicle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return student list
        return BusList;
    }

    public Vehicle getBusWithID(String id) {
        Vehicle vehicle = new Vehicle();
        String[] arg = {id};
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE + " WHERE " + this.id + "='" + id + "'";
        Log.i("Query : ", selectQuery);
        Cursor cur = db.rawQuery(selectQuery, null);
        if (cur != null && cur.moveToFirst()) {
            vehicle.setName(cur.getString(cur.getColumnIndex(name)));
            vehicle.setStart(cur.getString(cur.getColumnIndex(start)));
            vehicle.setEnd(cur.getString(cur.getColumnIndex(end)));
            vehicle.setFprice(cur.getString(cur.getColumnIndex(fprice)));
            vehicle.setSprice(cur.getString(cur.getColumnIndex(sprice)));
            vehicle.setDeparture(cur.getString(cur.getColumnIndex(departure)));
            vehicle.setTime(cur.getString(cur.getColumnIndex(time)));
            vehicle.setAddress(cur.getString(cur.getColumnIndex(address)));
            vehicle.setPh_no(cur.getString(cur.getColumnIndex(ph_no)));
            vehicle.setCategory(cur.getString(cur.getColumnIndex(category)));
            vehicle.setFavorite(cur.getString(cur.getColumnIndex(favorite)));
        } else {
            Log.i("Null", "Error");
        }
        return vehicle;
    }


    public List<Vehicle> getAllvessel(String type, String start, String end) {
        List<Vehicle> VesselList = new ArrayList<Vehicle>();
        // Select All Query
        String selectQuery = "SELECT " + id + "," + name + "," + fprice + "," + sprice + ","+favorite+" FROM " + TABLE + " WHERE " + category + " = " + "'" + type + "' AND start='" + start + "' AND end='" + end + "'";
        Log.i("Query : ", selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Vehicle vehicle = new Vehicle();
                // vehicle.setId(cursor.getString(0));
                vehicle.setName(cursor.getString(1));
                vehicle.setFprice(cursor.getString(2));
                vehicle.setSprice(cursor.getString(3));
                vehicle.setId(cursor.getString(0));
                vehicle.setFavorite(cursor.getString(4));

                // Adding student to list
                VesselList.add(vehicle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return student list
        return VesselList;
    }

    public List<Vehicle> getAllFlight(String type, String start, String end) {
        List<Vehicle> PlaneList = new ArrayList<Vehicle>();
        // Select All Query
        String selectQuery = "SELECT " + id + "," + name + "," + fprice + "," + sprice + ","+favorite+" FROM " + TABLE + " WHERE " + category + " = " + "'" + type + "' AND start='" + start + "' AND end='" + end + "'";
        Log.i("Query : ", selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            Log.i("Size : ", cursor.getCount() + "");
            do {
                Vehicle vehicle = new Vehicle();
                //vehicle.setId(cursor.getString(0));
                vehicle.setName(cursor.getString(1));
                vehicle.setFprice(cursor.getString(2));
                vehicle.setSprice(cursor.getString(3));
                vehicle.setId(cursor.getString(0));

                // Adding student to list
                PlaneList.add(vehicle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return student list
        return PlaneList;
    }


    public List<Vehicle> getAllTrain(String type, String start, String end) {
        List<Vehicle> TrainList = new ArrayList<Vehicle>();
        // Select All Query
        String selectQuery = "SELECT " + id + "," + name + "," + fprice + "," + sprice + ","+favorite+" FROM " + TABLE + " WHERE " + category + " = " + "'" + type + "' AND start='" + start + "' AND end='" + end + "'";
        Log.i("Query : ", selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Vehicle vehicle = new Vehicle();
                //vehicle.setId(cursor.getString(0));
                vehicle.setName(cursor.getString(1));
                vehicle.setFprice(cursor.getString(2));
                vehicle.setSprice(cursor.getString(3));
                vehicle.setId(cursor.getString(0));

                // Adding student to list
                TrainList.add(vehicle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return student list
        return TrainList;
    }


    // Getting student Count
    public int getVehicleCount() {

        Cursor cursor = null;
        try {
            String countQuery = "SELECT * FROM " + TABLE;
            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery(countQuery, null);

            // return count
            return cursor.getCount();
        } finally {
            cursor.close();
        }
    }

    public int getBusList() {
        int size = 0;
        String query = "SELECT * FROM TRP";
        Cursor cur = this.getReadableDatabase().rawQuery(query, null);
        if (cur != null) {
            size = cur.getCount();
        }
        return size;
    }

    public void updateFav(String idd,String  fav)
    {
        String query="UPDATE "+TABLE+" SET "+favorite+" = '"+fav+ "' WHERE "+id+" = "+idd;

        getWritableDatabase().execSQL(query);
    }

    public List<Vehicle> getAllfavorite(String fav) {
        List<Vehicle> VesselList = new ArrayList<Vehicle>();
        // Select All Query
        String selectQuery = "SELECT " + id + "," + name + "," + fprice + "," + sprice +","+category+ ","+favorite+" FROM " + TABLE + " WHERE " + favorite+" = '"+fav+ "'";
        Log.i("Query : ", selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Log.e("Fav",cursor.getString(1));
                Vehicle vehicle = new Vehicle();
                // vehicle.setId(cursor.getString(0));
                vehicle.setName(cursor.getString(1));
                vehicle.setFprice(cursor.getString(2));
                vehicle.setSprice(cursor.getString(3));
                vehicle.setCategory(cursor.getString(4));
                vehicle.setId(cursor.getString(0));
                vehicle.setFavorite(cursor.getString(5));

                // Adding student to list
                VesselList.add(vehicle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return student list
        return VesselList;
    }

}
