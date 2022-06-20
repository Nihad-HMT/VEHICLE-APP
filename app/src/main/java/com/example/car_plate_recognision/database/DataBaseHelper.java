package com.example.car_plate_recognision.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.car_plate_recognision.model.UserModel;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "tbl_user";

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + "(userId INTEGER PRIMARY KEY, password VARCHAR, username VARCHAR, email VARCHAR, role VARCHAR, phone VARCHAR, nic VARCHAR, image VARCHAR)";
        db.execSQL(createTableStatement);
        String createTableVehicle = "CREATE TABLE " + VEHICLE_TABLE + "(userId INTEGER PRIMARY KEY, password VARCHAR, username VARCHAR, email VARCHAR)";
        db.execSQL(createTableVehicle);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(UserModel userModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("userId",userModel.getUserId());
        cv.put("email",userModel.getEmail());
        cv.put("password",userModel.getPassword());
        cv.put("username",userModel.getUsername());

        long insert = db.insert(USER_TABLE, null, cv);

        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}

