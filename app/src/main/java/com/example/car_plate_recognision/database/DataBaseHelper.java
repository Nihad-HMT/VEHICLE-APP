package com.example.car_plate_recognision.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.car_plate_recognision.model.UserModel;
import com.example.car_plate_recognision.model.VehicleModel;


public class DataBaseHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db = getWritableDatabase();

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateTableUser = "CREATE TABLE IF NOT EXISTS tbl_user(userId INTEGER PRIMARY KEY, password VARCHAR, username VARCHAR, email VARCHAR, role VARCHAR, phone VARCHAR, nic VARCHAR, image VARCHAR)";
        db.execSQL(sqlCreateTableUser);
        String createTableVehicle = "CREATE TABLE IF NOT EXISTS tbl_vehicle(vehicleId INTEGER PRIMARY KEY, plateNumber VARCHAR, owner VARCHAR, email VARCHAR, type VARCHAR, phone VARCHAR, colour VARCHAR, timeIn VARCHAR, timeOut VARCHAR)";
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
        cv.put("role",userModel.getRole());
        cv.put("phone",userModel.getPhone());
        cv.put("nic",userModel.getNic());
        cv.put("image",userModel.getImage());


        long insert = db.insert("tbl_user", null, cv);

        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean addVehicle(VehicleModel vehicleModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("vehicleId",vehicleModel.getVehicleId());
        cv.put("plateNumber",vehicleModel.getPlateNumber());
        cv.put("owner",vehicleModel.getOwner());
        cv.put("email",vehicleModel.getEmail());
        cv.put("type",vehicleModel.getType());
        cv.put("phone",vehicleModel.getPhone());
        cv.put("colour",vehicleModel.getColor());
        cv.put("timeIn",vehicleModel.getTimeIn());
        cv.put("timeOut",vehicleModel.getTimeOut());


        long insert = db.insert("tbl_vehicle", null, cv);

        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public DataBaseHelper(@Nullable Context context) {
        super(context,"parkme.db",null,1);
    }

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler)
    {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DataBaseHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    public String getUserRole(String uname)
    {
        String role;
        db = this.getWritableDatabase();
        String selectTableStatement="select role from tbl_user WHERE username = '" + uname + "'";
        Cursor res = db.rawQuery(selectTableStatement,null);
        res.moveToFirst();
        if (res.getCount() == 0) {
            role = "";
        } else {
            Log.e("GET ROLE ", res.getString(0)+"");
            role = res.getString(0);;
        }
        return role;
    }

}