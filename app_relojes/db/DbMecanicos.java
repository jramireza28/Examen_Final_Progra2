package com.example.app_relojes.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.app_relojes.entidades.Relojes;

import java.util.ArrayList;

public class DbMecanicos extends DbHelper{
    Context context;


    public DbMecanicos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarRelojes(String nombre, String contraseña){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("contraseña", contraseña);

             id = db.insert(TABLE_USUARIOS, null, values);
        }catch (Exception ex){

            ex.toString();
        }
        return id;
    }


    public ArrayList<Relojes> mostrarContactos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Relojes> listaRelojes = new ArrayList<>();
        Relojes relojes = null;
        Cursor cursorRelojes = null;


         cursorRelojes = db.rawQuery("SELECT * FROM "+ TABLE_USUARIOS , null);

                if (cursorRelojes.moveToFirst()){
                do {
                    relojes = new Relojes();
                    relojes.setId(cursorRelojes.getInt(0));
                    relojes.setNombre(cursorRelojes.getString(1));
                    relojes.setContraseña(cursorRelojes.getString(2));
                    listaRelojes.add(relojes);

                } while (cursorRelojes.moveToNext());
                }
                cursorRelojes.close();
        return listaRelojes;
    }
}
