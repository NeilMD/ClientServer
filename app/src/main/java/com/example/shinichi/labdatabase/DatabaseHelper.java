package com.example.shinichi.labdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shinichi on 2/9/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String schema = "dlsu";
    public static final int version = 1;

    public DatabaseHelper(Context context) {
        super(context, schema, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // we create the table
        // only caleld once. when db is not yet created
        // unless upgraded
        //always put new stmt here

        /*
        *
        * Create table if not exists student(
        *  id   integer primary key autoincrement,
        *  name text not null,
        *  address text not null,
        *  birthday text not null);
        *
         */
        String sql = "CREATE TABLE IF NOT EXISTS " + Student.table + " ( "
                      + Student.colID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                      + Student.colName + " TEXT NOT NULL, "
                      + Student.colBday + " TEXT NOT NULL );";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //only called when new version
        // migrate the data
        String sql =  " DROP TABLE IS EXISTS " + Student.table + " ;";
        db.execSQL(sql);
        onCreate(db);


    }

    public long addStudent(Student s){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(s.colName, s.getName());
        cv.put(s.colAdd, s.getAdd());
        cv.put(s.colBday, s.getBday());


        long id = db.insert(s.table,null, cv);


        db.close();

        return id;
    }

    public int updateStudent(Student s){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(s.colName,s.getName());
        cv.put(s.colAdd,s.getAdd());
        cv.put(s.colBday,s.getBday());
        int af = db.update(Student.table,cv, s.colID + " =? ", new String[]{s.getId() + ""});

        db.close();
        return af;
    }

    public int deleteStudent(int id){
        SQLiteDatabase db = getWritableDatabase();

       int r =  db.delete(Student.table, Student.colID + " =? ", new String[]{id+""});
        db.close();
        return r;
    }

    public Student getStudent(int id){
        Student s = null;
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(Student.table,null,Student.colID + " =? ", new String[]{id+""},null,null,null);


        if(c.moveToFirst()){

            s.setName(c.getString(c.getColumnIndex(Student.colName)));
            s.setAdd(c.getString(c.getColumnIndex(Student.colAdd)));
            s.setBday(c.getString(c.getColumnIndex(Student.colBday)));
            s.setId(id);

        }
        c.close();
        db.close();
        return s;
    }

    public Cursor getAllStudents(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c  = db.query(Student.table,null,null,null,null,null,null);
        //do not close db or cursor.
        return c;
    }



}
