package com.example.musicpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.musicpro.Model.Venue;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname="VenueData.db";

    public DbManager(Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String qry="create table VenueDetails(VenueName text not null, Address text not null,Time text not null)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS VenueDetails");
        onCreate(sqLiteDatabase);
    }

    public String addRecord(String un, String ps,String ti)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("VenueName", un);
        cv.put("Address", ps);
        cv.put("Time", ti);

        long res=db.insert("VenueDetails", null, cv);
        if(res==-1)
            return "Failed";
        else
            return "Successsfully inserted";

    }

    public ArrayList<Venue> getAllData() {
        ArrayList<Venue> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("Select * from VenueDetails", null);

        while (result.moveToNext()) {
            String name = result.getString(0);
            String address = result.getString(1);
            String time = result.getString(2);
            Venue v1=new Venue(name,address);//,time);

            arrayList.add(v1);
        }
        return arrayList;
    }
    public boolean update(String s, String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE VenueDetails SET name = "+"'"+s+"' "+ "WHERE VenueName = "+"'"+s1+"'");
        return true;
    }

    public boolean deleteTitle(String vn)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM VenueDetails  WHERE VenueName" + " = '"+vn+"'");
        return true;
    }

}
