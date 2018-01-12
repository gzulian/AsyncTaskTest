package com.example.root.asynctask.model;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 11-01-18.
 */

public class ConexionHelper extends SQLiteOpenHelper {
    private static final String NAME_DB = "mascotas";
    private static final int VERSION  = 1;

    public static final String TABLE_NAME = "mascota";
    public static final String[] TABLE_MASCOTA_COLUMN = {"id","nombre","raza","genero","peso"};


    public ConexionHelper(Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE "+TABLE_NAME+" (";
        createTable +=  TABLE_MASCOTA_COLUMN[0]+" integer primary key autoincrement, ";
        createTable +=  TABLE_MASCOTA_COLUMN[1]+" text, ";
        createTable +=  TABLE_MASCOTA_COLUMN[2]+" text, ";
        createTable +=  TABLE_MASCOTA_COLUMN[3]+" text, ";
        createTable +=  TABLE_MASCOTA_COLUMN[4]+" double); ";
        sqLiteDatabase.execSQL(createTable);

        String sqlInsert = "INSERT  INTO "+TABLE_NAME+" values (null, 'PEPE','Pastor','M',25.2)";
        sqLiteDatabase.execSQL(sqlInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
