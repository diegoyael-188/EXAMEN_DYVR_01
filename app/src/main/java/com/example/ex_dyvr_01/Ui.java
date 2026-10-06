package com.example.ex_dyvr_01;

import android.graphics.Color;
import android.view.View;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

final class Ui {

    static void edgeToEdge(ComponentActivity activity, View cabecera) {
        EdgeToEdge.enable(activity,
                SystemBarStyle.dark(Color.TRANSPARENT),
                SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT));
        int top = cabecera.getPaddingTop();
        ViewCompat.setOnApplyWindowInsetsListener(activity.findViewById(R.id.raiz), (v, insets) -> {
            Insets b = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
            cabecera.setPadding(cabecera.getPaddingLeft(), top + b.top, cabecera.getPaddingRight(), cabecera.getPaddingBottom());
            v.setPadding(b.left, 0, b.right, b.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }

    private Ui() {}
}
