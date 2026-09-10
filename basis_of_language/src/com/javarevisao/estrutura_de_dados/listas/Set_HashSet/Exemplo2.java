package com.javarevisao.estrutura_de_dados.listas.Set_HashSet;

// Exemplo de LinkedHashSet e de TreeSet

import com.sun.source.tree.Tree;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Exemplo2 {
    public static void main(String[] args) {
        Set<String> linguagens = new LinkedHashSet<>();
        linguagens.add("java");
        // garante que não seja inserido duas vezes assim como o Set normal:
        linguagens.add("java");
        linguagens.add("c#");
        linguagens.add("rust");
        linguagens.add("python");
        linguagens.add("go");
        linguagens.remove("go");


        // A diferença para o Set normal (HashSet) é que matém a ordem de inserção.
        // No HashSet a ordenação é feita por um agoritimo interno da classe
        for (String l : linguagens) {
            System.out.println(l);
        }

        // A principal caracterítica é a organização. Com Strings se organiza por orde alfabética.
        // Para números armazena em ordem crescente.
        Set<String> linguagens2 = new TreeSet<>();
        linguagens2.add("java");
        linguagens2.add("java");
        linguagens2.add("rust");
        linguagens2.add("c#");
        linguagens2.add("go");

        for (String l : linguagens2) {
            System.out.println(l);
        }

        // Para números
        Set<Integer> listaNumeros = new TreeSet<>();
        listaNumeros.add(100);
        listaNumeros.add(50);
        listaNumeros.add(150);
        listaNumeros.add(30);
        listaNumeros.add(80);

        for (Integer i : listaNumeros) {
            System.out.println(i);
        }

        // OBS: Essa ordenação possui um custo de desempenho. Para
        // listas grandes isso pode ser um problema
    }
}
