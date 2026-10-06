package com.example.ex_dyvr_01;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsuarioAdapter extends BaseAdapter {

    private final List<Usuario> todos;
    private List<Usuario> visibles;

    UsuarioAdapter(List<Usuario> usuarios) {
        todos = usuarios;
        visibles = usuarios;
    }

    void filtrar(String texto) {
        String q = texto.toLowerCase(Locale.ROOT);
        visibles = new ArrayList<>();
        for (Usuario u : todos) {
            if (u.nombre.toLowerCase(Locale.ROOT).contains(q) || u.usuario.toLowerCase(Locale.ROOT).contains(q)) visibles.add(u);
        }
        notifyDataSetChanged();
    }

    @Override public int getCount() { return visibles.size(); }
    @Override public Usuario getItem(int position) { return visibles.get(position); }
    @Override public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView != null ? convertView
                : LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        Usuario u = getItem(position);
        ((TextView) v.findViewById(R.id.tvNombre)).setText(u.nombre);
        ((TextView) v.findViewById(R.id.tvUsuario)).setText(u.usuario);
        mostrarAvatar(v, u);
        return v;
    }

    static void mostrarAvatar(View v, Usuario u) {
        TextView tvInicial = v.findViewById(R.id.tvInicial);
        ImageView ivFoto = v.findViewById(R.id.ivFoto);
        boolean foto = u.color == Usuario.FOTO;
        ivFoto.setVisibility(foto ? View.VISIBLE : View.GONE);
        tvInicial.setVisibility(foto ? View.GONE : View.VISIBLE);
        if (!foto) {
            tvInicial.setText(u.nombre.substring(0, 1));
            tvInicial.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(v.getContext(), u.color)));
        }
    }
}
