package com.javarevisao.estrutura_de_dados.listas.Map_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/*
    A principal funcionalidade é fazer uma lista de pares de classes,
    ou seja, cada posição da lista estará contendo duas classes, que
    possuem alguma relação uma com a outra.
 */

public class Exemplo1 {
    public static void main(String[] args) {

        // Chave depois o valor. As chaves são únicas
        Map<String, Double> listaQualquer = new HashMap<>();

        // Para adicionar elementos usa-se o .put()
        listaQualquer.put("BTC", 0.00002);
        listaQualquer.put("ETH", 1.033);
        listaQualquer.put("XLM", 3.56);
        listaQualquer.put("USDC", 120.35);

        System.out.println("\n" + listaQualquer);

        // Para acessar um elemento é com o metodo .get()
        System.out.println("\nQuantidade de XLM: " + listaQualquer.get("XLM"));

        // Para alterar os valores usa-se o .put() novamente, já que as chaves
        // não podem ser repetidas o metodo ja entende que se deve atualizar o valor
        listaQualquer.put("XLM", 10.077);
        System.out.println("\nQuantidade de XLM: " + listaQualquer.get("XLM") + "\n");

        // Para remover uma valor
        listaQualquer.remove("XLM");

        // Para percorrer há metodos específicos
        for (Map.Entry<String, Double> variavel : listaQualquer.entrySet()) {

            // .getKey() pega a chave e .getValue() pega o valor da posição em que se está
            System.out.println(variavel.getKey() + ": " +variavel.getValue());
        }

        // Forma mais simples de se fazer um while com Map:
        // Junta-se todas as chaves e as percorre
        Iterator<String> chaves = listaQualquer.keySet().iterator();
        // do tipo String porque listaQualquer possui as chaves em forma de String
        while (chaves.hasNext()) {
            String chaveEspecifica = chaves.next();
            Double conteudo = listaQualquer.get(chaveEspecifica);
            System.out.println("Chave: " + chaveEspecifica + ", Conteúdo: " + conteudo);
        }

    }
}

/*
    Dentro do framework de coleções, existem várias implementações do Map, incluindo HashMap,
    TreeMap, e LinkedHashMap, cada uma com características e usos específicos. Por exemplo, o
    HashMap é conhecido por sua eficiência em operações de busca, inserção e remoção, pois não
    mantém nenhuma ordem para as chaves ou valores. Por outro lado, o TreeMap mantém suas chaves
    em uma ordem crescente, facilitando a iteração ordenada sobre os pares de chave-valor,
    enquanto o LinkedHashMap preserva a ordem de inserção dos elementos.
 */

/*
    entrySet(): Este metodo retorna um conjunto (Set) de todas as entradas (pares chave-valor)
    contidas no mapa. Cada elemento do conjunto é do tipo Map.Entry<K,V>, onde K e V são o tipo
    da chave e do valor, respectivamente. No exemplo, o metodo entrySet() é utilizado em combinação
    com um loop for-each para iterar sobre o mapa e exibir todas as chaves (texto) e seus valores
    correspondentes (double):
    for (Map.Entry<String, Double> variavel : listaQualquer.entrySet()).
 */

/*
    A Classe TreeMap possui a mesma ideia das variações do Set.
    TreeMap ordena na inserção (por ordem alfabética, ordem crescente etc)
 */
