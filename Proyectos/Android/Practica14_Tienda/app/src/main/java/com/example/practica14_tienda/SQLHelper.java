package com.example.practica14_tienda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.practica14_tienda.Contracts.ArticuloContract;
import com.example.practica14_tienda.Contracts.CarritoContract;
import com.example.practica14_tienda.Contracts.UsuarioContract;
import com.example.practica14_tienda.Entidades.Usuario;

public class SQLHelper extends SQLiteOpenHelper {
    final String BBDD = "tienda.db";

    public SQLHelper(@Nullable Context context) {
        super(context, "tienda.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UsuarioContract.TABLE_NAME + " (" +
                UsuarioContract.USER + " text primary key, " +
                UsuarioContract.PASS + " text not null, " +
                UsuarioContract.NOMBRE + " text not null" +
                "); ");
        db.execSQL("create table " + ArticuloContract.TABLE_NAME + "( " +
                ArticuloContract.CODIGO +  " int primary key, " +
                ArticuloContract.NOMBRE + " text not null, " +
                ArticuloContract.DESCRIPCION + " text not null, " +
                ArticuloContract.COLOR + " text not null,  " +
                ArticuloContract.PRECIO + " real not null" +
                "); ");
        db.execSQL("create table " + CarritoContract.TABLE_NAME + "( " +
                UsuarioContract.USER + " text primary key, " +
                ArticuloContract.CODIGO + " int primary key, " +
                CarritoContract.CANTIDAD + " int not null, " +
                " FOREIGN KEY( " + UsuarioContract.USER + " ) REFERENCES " + UsuarioContract.TABLE_NAME + " ( " + UsuarioContract.USER + " ), " +
                " FOREIGN KEY( " + ArticuloContract.CODIGO + ") REFERENCES " + ArticuloContract.TABLE_NAME + " ( " + ArticuloContract.CODIGO + " ) " +
                ");");
        db.execSQL("INSERT INTO " + UsuarioContract.TABLE_NAME + " VALUES ( user1, pass1, DAVID);");
        db.execSQL("INSERT INTO " + UsuarioContract.TABLE_NAME + " VALUES ( user2, pass2, CARRO);");
        String descr = "lapiz normalito sin gran cosa";
        db.execSQL("INSERT INTO " + ArticuloContract.TABLE_NAME + " VALUES ( 111, Lápiz," + descr + " , amarillo, 2);");
        descr = "goma de borrar de las de toda la vida";
        db.execSQL("INSERT INTO " + ArticuloContract.TABLE_NAME + " VALUES ( 222, goma, " + descr + ", blanca, 1);");
        descr = "folios blancos de buen gramaje";
        db.execSQL("INSERT INTO " + ArticuloContract.TABLE_NAME + " VALUES ( 333, Folios, " + descr + ", azules, 10);");
        descr = "Estuche feo feo de la patrulla canina";
        db.execSQL("INSERT INTO " + ArticuloContract.TABLE_NAME + " VALUES ( 444, Estuche, " + descr + ", negro, 9);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean consultaUser(Usuario u){
        boolean existe = false;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(UsuarioContract.TABLE_NAME, null, null, null, null, null, null);
        while(c.moveToNext()){
            String user = c.getString(c.getColumnIndexOrThrow(UsuarioContract.USER));
            if (user.equals(u.getUser())){
                existe = true;
            }
        }
        return existe;
    }


}
