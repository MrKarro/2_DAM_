package com.example.practica8_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class PropietarioActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propietario);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        finish();
        return false;
    }
}