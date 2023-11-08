package com.example.practica8_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    Button insti, whats;
    LinearLayout principal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insti = findViewById(R.id.buttonInsti);
        whats = findViewById(R.id.buttonWhats);
        principal = findViewById(R.id.principal);

        principal.setOnTouchListener(this);
        insti.setOnClickListener(this);
        whats.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonInsti){
            Uri uriUrl = Uri.parse("https://www.iesvenancioblanco.es/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);

        } else if (view.getId() == R.id.buttonWhats){
            Intent intent = new Intent(this, WhatsActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Intent intent = new Intent(this, PropietarioActivity.class);
        startActivity(intent);
        return false;
    }

}