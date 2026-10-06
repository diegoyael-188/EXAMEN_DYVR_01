package com.example.ex_dyvr_01;

import java.util.ArrayList;
import java.util.List;

public class Mensaje {

    final String texto;
    final String hora;
    final boolean enviado;

    Mensaje(String texto, String hora, boolean enviado) {
        this.texto = texto;
        this.hora = hora;
        this.enviado = enviado;
    }

    static List<Mensaje> conversacion(String primerNombre) {
        String[][] datos = {
                {"que onda " + primerNombre.toLowerCase() + " como andas", "09:32"},
                {"bien bien y tu??", "09:33"},
                {"aqui nomas jaja oye q haces al rato", "09:34"},
                {"nada x q", "09:35"},
                {"vamos a jugar una cascarita no?", "09:36"},
                {"vaaa a q hora", "09:36"},
                {"como a las 5 en la cancha de siempre", "09:37"},
                {"sale ahi te veo", "09:38"},
                {"llevas el balon? el mio ya esta ponchado jaja", "09:38"},
                {"si yo lo llevo", "09:39"},
                {"oye y cuantos somos", "09:40"},
                {"ps tu yo y ya jaja", "09:40"},
                {"hay q invitar a mas banda", "09:41"},
                {"le digo a los del grupo?", "09:42"},
                {"siii diles", "09:42"},
                {"ya les dije, 3 confirmaron", "09:45"},
                {"buenisimo ya armamos dos equipos", "09:45"},
                {"no llegues tarde eh", "09:46"},
                {"jajaja yo nunca llego tarde", "09:46"},
                {"aja si como no, nos vemos", "09:47"},
        };
        List<Mensaje> lista = new ArrayList<>();
        for (int i = 0; i < datos.length; i++) {
            lista.add(new Mensaje(datos[i][0], datos[i][1], i % 2 == 0));
        }
        return lista;
    }
}
