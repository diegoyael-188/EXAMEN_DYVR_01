package com.example.ex_dyvr_01;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    static final String EXTRA_NOMBRE = "nombre";
    static final String EXTRA_USUARIO = "usuario";
    static final String EXTRA_COLOR = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        Ui.edgeToEdge(this, toolbar);

        Usuario contacto = new Usuario(getIntent().getStringExtra(EXTRA_NOMBRE),
                getIntent().getStringExtra(EXTRA_USUARIO),
                getIntent().getIntExtra(EXTRA_COLOR, Usuario.FOTO));
        ((TextView) findViewById(R.id.tvNombre)).setText(contacto.nombre);
        UsuarioAdapter.mostrarAvatar(toolbar, contacto);

        List<Mensaje> mensajes = Mensaje.conversacion(contacto.nombre.split(" ")[0]);
        MensajeAdapter adapter = new MensajeAdapter(mensajes);
        ((ListView) findViewById(R.id.lista)).setAdapter(adapter);

        toolbar.setNavigationOnClickListener(v -> finish());
        toolbar.setOnMenuItemClickListener(item -> {
            mensajes.clear();
            adapter.notifyDataSetChanged();
            return true;
        });

        EditText etMensaje = findViewById(R.id.etMensaje);
        findViewById(R.id.btnEnviar).setOnClickListener(v -> {
            String texto = etMensaje.getText().toString().trim();
            if (texto.isEmpty()) return;
            String hora = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            mensajes.add(new Mensaje(texto, hora, true));
            adapter.notifyDataSetChanged();
            etMensaje.setText("");
        });
        findViewById(R.id.btnAdjuntar).setOnClickListener(v ->
                Toast.makeText(this, R.string.adjuntar, Toast.LENGTH_SHORT).show());
    }
}
