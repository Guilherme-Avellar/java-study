package com.javarevisao.estrutura_de_dados;

import java.util.ArrayList;
import java.util.List;

public class Exemplo_ArrayList {
    public static void exemplo() {

        List lista = new ArrayList();
        lista.add("BTC");
        lista.add("ETH");
        lista.add("BTC");

        // Formato da lista em print puro
        System.out.println("Formato da lista em print puro: " + lista);

        // Para consultar um valor pelo indice
        System.out.println("Valor no indice 1: " + lista.get(1));


        // para saber o tamanho da lista usa-se .size()
        System.out.println("Tamanho da lista: " + lista.size());
        // para pegar o indice de um valor
        System.out.println("Posição de BTC: " + lista.indexOf("BTC"));
        // como tem dois BTC na lista, ele vai pegar a primeira ocorrencia

        // para remover um item
        lista.remove("BTC");
        // O que é repetido e vem depois permanece ou os dois são removidos?
        System.out.println("Posição de BTC depois de remover repetido: " + lista.indexOf("BTC"));
        // permanece, posição 1 agora

        // adicionando um elemento em um indice especifico
        lista.add(1, "BNB");
        // O que acontece com BTC que estava no indice 1, onde BNB foi adicionado?
        System.out.println("Adicionado BNB no indice 1. Indice BTC: " + lista.indexOf("BTC") + " Indice BNB: "
                + lista.indexOf("BNB"));
        // É passado para frente, vai para o indice 2

        // Para percorrer
        for (Object o : lista) {
            System.out.println(o);
        }



    }
}
