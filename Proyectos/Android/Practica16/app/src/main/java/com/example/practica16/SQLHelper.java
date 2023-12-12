package com.example.practica16;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.practica16.Modelo.Vehiculo;
import com.example.practica16.Modelo.VehiculoContract;

import java.util.ArrayList;

public class SQLHelper extends SQLiteOpenHelper {

    final String BBDD = "concesionario.db";

    public SQLHelper(@Nullable Context context) {
        super(context, "concesionario.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + VehiculoContract.TABLE_NAME + "( " +
                VehiculoContract.NUM_BASTI +  " int primary key, " +
                VehiculoContract.MARCA + " text not null, " +
                VehiculoContract.MODELO + " text not null, " +
                VehiculoContract.COLOR + " text not null,  " +
                VehiculoContract.COMBUSTIBLE + " real not null, " +
                VehiculoContract.KMS + " int not null" +
                "); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Vehiculo> consultaVehiculos(){
        ArrayList<Vehiculo> coches = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(VehiculoContract.TABLE_NAME, null, null, null, null, null, null);
        while (c.moveToNext()){
            Vehiculo v = new Vehiculo();
            v.setNumBastidor(c.getInt(c.getColumnIndexOrThrow(VehiculoContract.NUM_BASTI)));
            v.setMarca(c.getString(c.getColumnIndexOrThrow(VehiculoContract.MARCA)));
            v.setModelo(c.getString(c.getColumnIndexOrThrow(VehiculoContract.MODELO)));
            v.setColor(c.getString(c.getColumnIndexOrThrow(VehiculoContract.COLOR)));
            v.setCombustible(c.getString(c.getColumnIndexOrThrow(VehiculoContract.COMBUSTIBLE)));
            v.setKilometraje(c.getInt(c.getColumnIndexOrThrow(VehiculoContract.KMS)));

            coches.add(v);
        }
        return coches;
    }

}
