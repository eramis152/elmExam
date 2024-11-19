package com.example.elmexam;

import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View mainView = findViewById(R.id.main);
        View fondoAzulClaro = findViewById(R.id.fondo_azul_claro);
        View cuadroAzulOscuro = findViewById(R.id.cuadro_azul_oscuro);
        View circuloAmarillo = findViewById(R.id.circulo_amarillo);
        ImageView caraFeliz = findViewById(R.id.icon_smile);

        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainView.setOnClickListener(v -> {
            Log.d(TAG, "Main view clicked!");
            startSunsetAnimation(fondoAzulClaro, cuadroAzulOscuro, circuloAmarillo);
        });

        caraFeliz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Actividad2.class);
            startActivity(intent);
        });
    }

    private void startSunsetAnimation(View fondoAzulClaro, View cuadroAzulOscuro, View circuloAmarillo) {
        int startColor = getResources().getColor(android.R.color.holo_blue_light);
        int sunsetColor = getResources().getColor(android.R.color.holo_orange_light);
        int nightColor = android.graphics.Color.parseColor("#05192E");

        ObjectAnimator toSunset = ObjectAnimator.ofArgb(
                fondoAzulClaro, "backgroundColor", startColor, sunsetColor);
        toSunset.setDuration(3000);
        toSunset.setEvaluator(new ArgbEvaluator());

        ObjectAnimator toNight = ObjectAnimator.ofArgb(
                fondoAzulClaro, "backgroundColor", sunsetColor, nightColor);
        toNight.setDuration(1500);
        toNight.setEvaluator(new ArgbEvaluator());

        AnimatorSet backgroundAnimation = new AnimatorSet();
        backgroundAnimation.playSequentially(toSunset, toNight);

        circuloAmarillo.post(() -> {
            float startY = 0;
            float endY = (cuadroAzulOscuro.getY() - circuloAmarillo.getHeight());

            Log.d(TAG, "Start Y: " + startY + ", End Y: " + endY);

            ObjectAnimator moveSun = ObjectAnimator.ofFloat(
                    circuloAmarillo, "translationY", startY, endY);
            moveSun.setDuration(5000);

            moveSun.addListener(new android.animation.AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    Log.d(TAG, "Sunset animation finished, sun is now hidden.");
                }
            });

            AnimatorSet fullAnimation = new AnimatorSet();
            fullAnimation.playTogether(backgroundAnimation, moveSun);
            fullAnimation.start();
        });
    }
}
