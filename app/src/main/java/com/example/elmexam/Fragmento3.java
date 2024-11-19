package com.example.elmexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmento3 extends Fragment {

    private SeekBar seekBarRojo, seekBarVerde, seekBarAzul;
    private Button botonCambiarColor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_3, container, false);

        seekBarRojo = view.findViewById(R.id.seekbar_rojo);
        seekBarVerde = view.findViewById(R.id.seekbar_verde);
        seekBarAzul = view.findViewById(R.id.seekbar_azul);
        botonCambiarColor = view.findViewById(R.id.boton_cambiar_color);

        botonCambiarColor.setOnClickListener(v -> {
            int rojo = seekBarRojo.getProgress();
            int verde = seekBarVerde.getProgress();
            int azul = seekBarAzul.getProgress();
            ((Comunicador) getActivity()).cambiarColor(rojo, verde, azul);
        });

        return view;
    }
}
