package com.example.examen2_davidcarrosalinas_2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Mascotas.db";
    private static final int DATABASE_VERSION = 1;


    public SQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "CREATE TABLE " + AnimalContract.TABLE_NAME + "(" +
                AnimalContract.CODIGO + " integer primary key, " +
                AnimalContract.NOMBRE + " text not null, " +
                AnimalContract.PESO + " decimal not null, " +
                AnimalContract.TIPO + " text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int vieja, int nueva) {



    }

    public void insertaAnimal(Animal a){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AnimalContract.CODIGO, a.getCodigo());
        values.put(AnimalContract.NOMBRE, a.getNombre());
        values.put(AnimalContract.PESO, a.getPeso());
        values.put(AnimalContract.TIPO, a.getTipo());

        db.insert(AnimalContract.TABLE_NAME, null, values);
    }

    public ArrayList<Animal> consultaTodo(){
        ArrayList<Animal> animales = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(
                AnimalContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while (c.moveToNext()){
            int cod = c.getInt(c.getColumnIndexOrThrow(AnimalContract.CODIGO));
            String nom = c.getString(c.getColumnIndexOrThrow(AnimalContract.NOMBRE));
            double pes = c.getDouble(c.getColumnIndexOrThrow(AnimalContract.PESO));
            String tip = c.getString(c.getColumnIndexOrThrow(AnimalContract.TIPO));
            Animal a = new Animal(cod, nom, pes, tip);

            animales.add(a);

        }
        return animales;
    }
    public int eliminaAnimal(Animal a){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(AnimalContract.TABLE_NAME,
                AnimalContract.CODIGO + " = ?",
                new String[]{String.valueOf(a.getCodigo())}
        );

    }

    public ArrayList<Animal> consultaAnimal(String animal){
        ArrayList<Animal> animales = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(
                AnimalContract.TABLE_NAME,
                null,
                AnimalContract.TIPO + " = ?",
                new String[]{animal},
                null,
                null,
                null
        );
        while (c.moveToNext()){
            int cod = c.getInt(c.getColumnIndexOrThrow(AnimalContract.CODIGO));
            String nom = c.getString(c.getColumnIndexOrThrow(AnimalContract.NOMBRE));
            double pes = c.getDouble(c.getColumnIndexOrThrow(AnimalContract.PESO));
            String tip = c.getString(c.getColumnIndexOrThrow(AnimalContract.TIPO));
            Animal a = new Animal(cod, nom, pes, tip);
            animales.add(a);


        }
        return animales;
    }

}
