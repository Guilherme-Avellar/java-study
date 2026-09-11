package com.javarevisao.exercicios.lambda_streams;

import java.util.ArrayList;
import java.util.List;

public class Texto_lista {

    @FunctionalInterface
    interface Transformador {
        String transformador (String texto);
    }

    static List<String> aplicar (List<String> lista, Transformador t) {
        List<String> listaTransformada = new ArrayList<>();
        for (String s : lista) {
            listaTransformada.add(t.transformador(s));
        }
        return listaTransformada;
    }

    static void main() {

        List<String> lista = List.of("java", "lambda", "funcional");

        System.out.println("tudo em maiúsculo: " + aplicar(lista, s -> s.toUpperCase()));

        System.out.println("tudo invertido: " + aplicar(lista, (s) -> {
            StringBuilder nova = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                nova.append(s.charAt(i));
            }
            return nova.toString();
        }));
    }
}
