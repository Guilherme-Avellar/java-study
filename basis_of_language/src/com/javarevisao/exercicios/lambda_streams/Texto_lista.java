package com.javarevisao.exercicios.lambda_streams;

import java.util.ArrayList;
import java.util.List;

public class Texto_lista {

    // como se fosse uma interface de função
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

        // A implementação da FunctionalInterface acontece dentro da lâmbda.
        System.out.println("tudo em maiúsculo: " + aplicar(lista, s -> {
            StringBuilder novoTexto = new StringBuilder(s);
            for (int i = 0; i < novoTexto.length(); i++) {
                if((int) novoTexto.charAt(i) >= 'a' && (int) novoTexto.charAt(i) <= 'z')
                    novoTexto.setCharAt(i, (char) ((int) (novoTexto.charAt(i)) - 32));
            }
            return novoTexto.toString();
        }));

        System.out.println("texto invertido: " + aplicar(lista, (s) -> {
            StringBuilder nova = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                nova.append(s.charAt(i));
            }
            return nova.toString();
        }));

        
    }
}
