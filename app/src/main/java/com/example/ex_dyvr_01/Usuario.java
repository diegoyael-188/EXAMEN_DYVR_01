package com.example.ex_dyvr_01;

import java.util.Arrays;
import java.util.List;

public class Usuario {

    static final int FOTO = 0;

    final String nombre;
    final String usuario;
    final int color;

    Usuario(String nombre, String usuario, int color) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.color = color;
    }

    static List<Usuario> lista() {
        return Arrays.asList(
                new Usuario("Cristiano Ronaldo", "CR7", FOTO),
                new Usuario("Leo Messi", "LM10", R.color.azul),
                new Usuario("Neymar Júnior", "NJR10", R.color.color_avatarMorado),
                new Usuario("Kylian Mbappé", "KM10", FOTO),
                new Usuario("Erling Haaland", "EH9", R.color.color_avatarVerde),
                new Usuario("Zlatan Ibrahimović", "Ibra", FOTO),
                new Usuario("Ronaldo Nazário", "R9", R.color.color_avatarNaranja),
                new Usuario("Ronaldinho Gaúcho", "R10", R.color.azul),
                new Usuario("Zinedine Zidane", "Zizou", FOTO),
                new Usuario("David Beckham", "Becks", R.color.color_avatarMorado),
                new Usuario("Kevin De Bruyne", "KDB17", R.color.color_avatarVerde),
                new Usuario("Vinícius Júnior", "ViniJr", FOTO),
                new Usuario("Sergio Ramos", "SR4", R.color.color_avatarNaranja),
                new Usuario("Gianluigi Buffon", "Gigi1", R.color.azul),
                new Usuario("Robert Lewandowski", "Lewy9", FOTO),
                new Usuario("Karim Benzema", "KB9", R.color.color_avatarMorado),
                new Usuario("Javier Hernández", "Chicharito", R.color.color_avatarVerde),
                new Usuario("Mohamed Salah", "MoSalah11", FOTO),
                new Usuario("Lamine Yamal", "LY10", R.color.color_avatarNaranja),
                new Usuario("Luis Suárez", "Pistolero9", R.color.azul));
    }
}
