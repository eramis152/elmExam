package com.example.elmexam;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmento2 extends Fragment {

    private TextView textoVista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_2, container, false);
        textoVista = view.findViewById(R.id.texto_vista);
        return view;
    }

    public void actualizarTexto(String texto, float tamano) {
        textoVista.setText(texto);
        textoVista.setTextSize(tamano);
    }

    public void actualizarColor(int rojo, int verde, int azul) {
        textoVista.setTextColor(Color.rgb(rojo, verde, azul));
    }
}
