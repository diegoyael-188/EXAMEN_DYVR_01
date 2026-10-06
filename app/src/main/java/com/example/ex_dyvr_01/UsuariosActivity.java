package com.example.ex_dyvr_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class UsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        Ui.edgeToEdge(this, toolbar);

        List<Usuario> usuarios = Usuario.lista();
        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
        ListView lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener((p, v, pos, id) -> abrirChat(adapter.getItem(pos)));

        SearchView buscar = (SearchView) toolbar.getMenu().findItem(R.id.buscar).getActionView();
        buscar.setQueryHint(getString(R.string.buscar));
        buscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String q) { return false; }
            @Override public boolean onQueryTextChange(String q) {
                adapter.filtrar(q);
                return true;
            }
        });

        BottomNavigationView nav = findViewById(R.id.nav);
        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_chat) abrirChat(usuarios.get(0));
            else if (id == R.id.nav_perfil) startActivity(new Intent(this, PerfilActivity.class));
            return id == R.id.nav_usuarios;
        });
    }

    private void abrirChat(Usuario u) {
        startActivity(new Intent(this, ChatActivity.class)
                .putExtra(ChatActivity.EXTRA_NOMBRE, u.nombre)
                .putExtra(ChatActivity.EXTRA_USUARIO, u.usuario)
                .putExtra(ChatActivity.EXTRA_COLOR, u.color));
    }
}
