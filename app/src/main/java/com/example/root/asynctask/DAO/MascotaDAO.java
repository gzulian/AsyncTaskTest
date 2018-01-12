package com.example.root.asynctask.DAO;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;

import com.example.root.asynctask.model.ConexionHelper;
import com.example.root.asynctask.model.Mascota;

import java.util.ArrayList;

/**
 * Created by root on 11-01-18.
 */

public class MascotaDAO {
    private ConexionHelper helper;
    private ContentValues values;
    private SQLiteDatabase db;
    public MascotaDAO(Context context) {
        helper = new ConexionHelper(context);
        values = new ContentValues();

    }

    public void save(Mascota m){
        db = helper.getWritableDatabase();
        values.clear();
        values.put(ConexionHelper.TABLE_MASCOTA_COLUMN[1],m.getNombre());
        values.put(ConexionHelper.TABLE_MASCOTA_COLUMN[2],m.getRaza());
        values.put(ConexionHelper.TABLE_MASCOTA_COLUMN[3],m.getGenero());
        values.put(ConexionHelper.TABLE_MASCOTA_COLUMN[4],m.getPeso());
        if(m.getId() == 0){

            db.insert(helper.TABLE_NAME,null,values);
            Log.e("INFO","INSERT");

        }else{
            String cod = String.valueOf(m.getId());
            db.update(ConexionHelper.TABLE_NAME,values,"id=?",new String[]{cod});
        }
    }
    public Mascota findById(int id){
        String cod = String.valueOf(id);
        db = helper.getWritableDatabase();
        Cursor c;
        c=db.rawQuery("SELECT * FROM "+ConexionHelper.TABLE_NAME,new String[]{cod});
        Mascota m = null;
        if (c.moveToNext()) {
            m = new Mascota();
            m.setId(id);
            m.setNombre(c.getString(1));
            m.setRaza(c.getString(2));
            m.setGenero(c.getString(3));
            m.setPeso(Float.parseFloat(c.getString(4)) );
        }
        return  m;
    }
    public ArrayList<Mascota> findAll(){
        db = helper.getWritableDatabase();
        Cursor c;
        c=db.rawQuery("SELECT * FROM "+ConexionHelper.TABLE_NAME,null);
        ArrayList mascotas = new ArrayList<>();
        while (c.moveToNext()) {
            Mascota m = new Mascota();
            m.setId(c.getInt(0));
            m.setNombre(c.getString(1));
            m.setRaza(c.getString(2));
            m.setGenero(c.getString(3));
            m.setPeso(c.getFloat(4));
            mascotas.add(m);
        }
        return  mascotas;
    }
    public void delete(int id){
        String cod = String.valueOf(id);
        db = helper.getWritableDatabase();
        db.delete(ConexionHelper.TABLE_NAME,"id=?",new String[]{cod});

    }



}
