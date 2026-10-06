package com.example.ex_dyvr_01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        Ui.edgeToEdge(this, toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        SharedPreferences prefs = getSharedPreferences(LoginActivity.PREFS, MODE_PRIVATE);
        if (prefs.getBoolean(LoginActivity.SESION_REGISTRADO, false)) {
            ((TextView) findViewById(R.id.tvPerfilNombre)).setText(prefs.getString(LoginActivity.REG_NOMBRE, ""));
            ((TextView) findViewById(R.id.tvPerfilUsuario)).setText(prefs.getString(LoginActivity.REG_USUARIO, ""));
            ((TextView) findViewById(R.id.tvPerfilCorreo)).setText(prefs.getString(LoginActivity.REG_CORREO, ""));
        }

        findViewById(R.id.btnCerrarSesion).setOnClickListener(v -> {
            prefs.edit().remove(LoginActivity.SESION_ACTIVA).remove(LoginActivity.SESION_REGISTRADO).apply();
            startActivity(new Intent(this, LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        });
    }
}
