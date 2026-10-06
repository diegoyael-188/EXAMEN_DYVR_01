package com.example.ex_dyvr_01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    static final String PREFS = "sesion";
    static final String SESION_ACTIVA = "activa";
    static final String SESION_REGISTRADO = "registrado";
    static final String REG_NOMBRE = "reg_nombre";
    static final String REG_USUARIO = "reg_usuario";
    static final String REG_CORREO = "reg_correo";
    static final String REG_CLAVE = "reg_clave";
    private static final String USUARIO = "admin";
    private static final String CLAVE = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        if (prefs.getBoolean(SESION_ACTIVA, false)) {
            irAUsuarios();
            return;
        }
        setContentView(R.layout.activity_login);
        Ui.edgeToEdge(this, findViewById(R.id.cabecera));

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etContrasena = findViewById(R.id.etContrasena);
        CheckBox chkGuardar = findViewById(R.id.chkGuardar);

        findViewById(R.id.btnIniciar).setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String clave = etContrasena.getText().toString().trim();
            boolean esAdmin = USUARIO.equals(usuario) && CLAVE.equals(clave);
            boolean esRegistrado = clave.equals(prefs.getString(REG_CLAVE, null))
                    && (usuario.equals(prefs.getString(REG_USUARIO, null))
                    || usuario.equalsIgnoreCase(prefs.getString(REG_CORREO, null)));
            if (esAdmin || esRegistrado) {
                prefs.edit()
                        .putBoolean(SESION_ACTIVA, chkGuardar.isChecked())
                        .putBoolean(SESION_REGISTRADO, !esAdmin)
                        .apply();
                irAUsuarios();
            } else {
                Toast.makeText(this, R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btnCrear).setOnClickListener(v ->
                startActivity(new Intent(this, RegistroActivity.class)));
        findViewById(R.id.tvOlvidaste).setOnClickListener(v ->
                Toast.makeText(this, R.string.msg_olvidaste, Toast.LENGTH_SHORT).show());
    }

    private void irAUsuarios() {
        startActivity(new Intent(this, UsuariosActivity.class));
        finish();
    }
}
