package com.example.ex_dyvr_01;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        Ui.edgeToEdge(this, toolbar);

        toolbar.setNavigationOnClickListener(v -> finish());
        findViewById(R.id.tvYaTienes).setOnClickListener(v -> finish());

        TextInputLayout tilNombre = findViewById(R.id.tilNombre);
        TextInputLayout tilCorreo = findViewById(R.id.tilCorreo);
        TextInputLayout tilUsuario = findViewById(R.id.tilUsuario);
        TextInputLayout tilContrasena = findViewById(R.id.tilContrasena);
        TextInputLayout tilConfirmar = findViewById(R.id.tilConfirmar);

        findViewById(R.id.btnRegistrarse).setOnClickListener(v -> {
            String contrasena = texto(tilContrasena);
            boolean ok = validar(tilNombre, texto(tilNombre).length() >= 3, R.string.error_nombre)
                    & validar(tilCorreo, Patterns.EMAIL_ADDRESS.matcher(texto(tilCorreo)).matches(), R.string.error_correo)
                    & validar(tilUsuario, texto(tilUsuario).length() >= 5, R.string.hint_minimo_5)
                    & validar(tilContrasena, contrasena.length() >= 8, R.string.hint_minimo_8)
                    & validar(tilConfirmar, contrasena.equals(texto(tilConfirmar)), R.string.error_contrasenas);
            if (ok) {
                getSharedPreferences(LoginActivity.PREFS, MODE_PRIVATE).edit()
                        .putString(LoginActivity.REG_NOMBRE, texto(tilNombre))
                        .putString(LoginActivity.REG_USUARIO, texto(tilUsuario))
                        .putString(LoginActivity.REG_CORREO, texto(tilCorreo))
                        .putString(LoginActivity.REG_CLAVE, contrasena)
                        .apply();
                Toast.makeText(this, R.string.msg_registro_ok, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private static String texto(TextInputLayout til) {
        return til.getEditText().getText().toString().trim();
    }

    private boolean validar(TextInputLayout til, boolean valido, int error) {
        til.setError(valido ? null : getString(error));
        return valido;
    }
}
