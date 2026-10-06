package com.example.ex_dyvr_01;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class MensajeAdapter extends BaseAdapter {

    private final List<Mensaje> mensajes;

    MensajeAdapter(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override public int getCount() { return mensajes.size(); }
    @Override public Mensaje getItem(int position) { return mensajes.get(position); }
    @Override public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context c = parent.getContext();
        View v = convertView != null ? convertView
                : LayoutInflater.from(c).inflate(R.layout.item_mensaje, parent, false);
        Mensaje m = getItem(position);
        boolean yo = m.enviado;

        ((LinearLayout) v.findViewById(R.id.fila)).setGravity(yo ? Gravity.END : Gravity.START);
        v.findViewById(R.id.burbuja).setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(c, yo ? R.color.azul : R.color.color_burbujaRecibida)));

        TextView tvTexto = v.findViewById(R.id.tvTexto);
        tvTexto.setText(m.texto);
        tvTexto.setTextColor(ContextCompat.getColor(c, yo ? R.color.blanco : R.color.gris_oscuro));

        TextView tvHora = v.findViewById(R.id.tvHora);
        tvHora.setText(m.hora);
        tvHora.setTextColor(ContextCompat.getColor(c, yo ? R.color.azul_claro : R.color.gris));

        ImageView ivVisto = v.findViewById(R.id.ivVisto);
        ivVisto.setVisibility(yo ? View.VISIBLE : View.GONE);
        ivVisto.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(c, R.color.azul_claro)));
        return v;
    }
}
