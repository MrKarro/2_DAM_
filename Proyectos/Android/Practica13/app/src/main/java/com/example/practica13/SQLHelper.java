package com.example.practica13;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {
    final String BBDD = "Alumnos.db";

    public SQLHelper(@Nullable Context context) {
        super(context, "Alumnos.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //
        db.execSQL("create table " + AlumnosContract.TABLE_NAME + " (" +
                AlumnosContract.DNI + " text primary key, " +
                AlumnosContract.NOMBRE + " text not null," +
                AlumnosContract.EDAD + " integer not null)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("ALTER TABLE " + AlumnosContract.TABLE_NAME + " ADD COLUMN " + AlumnosContract.TELEFONO + " text ");
    }

    public long insertarAlumno(Alumno a){
        ContentValues values = new ContentValues();
        values.put(AlumnosContract.DNI, a.getDni());
        values.put(AlumnosContract.NOMBRE, a.getNombre());
        values.put(AlumnosContract.APELLIDOS, a.getApellidos());
        values.put(AlumnosContract.EDAD, a.getEdad());

        SQLiteDatabase db = getWritableDatabase();
        return db.insert(AlumnosContract.TABLE_NAME, null, values);

    }

    public void modificarAlumno(Alumno a){
        ContentValues values = new ContentValues();
        values.put(AlumnosContract.NOMBRE, a.getNombre());
        values.put(AlumnosContract.APELLIDOS, a.getApellidos());
        values.put(AlumnosContract.EDAD, a.getEdad());

        SQLiteDatabase db = getWritableDatabase();
        db.update(AlumnosContract.TABLE_NAME, values, AlumnosContract.DNI + " = ?", new String[]{a.getDni()});


    }

    public void borrarAlumno(Alumno a){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(AlumnosContract.TABLE_NAME,
                AlumnosContract.DNI + " = ?", new String[]{a.getDni()});
    }

    public Cursor consultarTodo() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(AlumnosContract.TABLE_NAME, null, null, null, null, null, null);
    }



}
