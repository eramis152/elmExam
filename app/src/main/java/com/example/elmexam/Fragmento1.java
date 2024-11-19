package com.example.elmexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmento1 extends Fragment {

    private EditText editText;
    private SeekBar seekBarTamano;
    private Button botonCambiarTexto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_1, container, false);

        editText = view.findViewById(R.id.edit_texto);
        seekBarTamano = view.findViewById(R.id.seekbar_tamano);
        botonCambiarTexto = view.findViewById(R.id.boton_cambiar_texto);

        botonCambiarTexto.setOnClickListener(v -> {
            float tamano = seekBarTamano.getProgress();
            String texto = editText.getText().toString();
            ((Comunicador) getActivity()).cambiarTexto(texto, tamano);
        });

        return view;
    }
}
