package com.example.elmexam;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class Actividad2 extends AppCompatActivity implements Comunicador {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_2);

        Fragmento1 fragmento1 = new Fragmento1();
        Fragmento2 fragmento2 = new Fragmento2();
        Fragmento3 fragmento3 = new Fragmento3();
        ImageView lunaLunera = findViewById(R.id.icon_moon);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmento1, fragmento1);
        transaction.replace(R.id.fragmento2, fragmento2);
        transaction.replace(R.id.fragmento3, fragmento3);
        transaction.commit();

        lunaLunera.setOnClickListener(v -> {
            Intent intent = new Intent(Actividad2.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void cambiarTexto(String texto, float tamano) {
        Fragmento2 fragmento2 = (Fragmento2) getSupportFragmentManager().findFragmentById(R.id.fragmento2);
        if (fragmento2 != null) {
            fragmento2.actualizarTexto(texto, tamano);
        }
    }

    @Override
    public void cambiarColor(int rojo, int verde, int azul) {
        Fragmento2 fragmento2 = (Fragmento2) getSupportFragmentManager().findFragmentById(R.id.fragmento2);
        if (fragmento2 != null) {
            fragmento2.actualizarColor(rojo, verde, azul);
        }
    }
}
