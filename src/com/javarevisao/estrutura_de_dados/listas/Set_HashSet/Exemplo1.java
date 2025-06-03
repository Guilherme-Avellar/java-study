package com.javarevisao.estrutura_de_dados.listas.Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
    É usado para armazenar valores ÚNICOS (mecanica principal), impedindo
    que se adicione objetos iguais. Não há indice.
    A busca por um conteúdo so pode ser feita pelo próprio conteúdo,
    pois não há indice.
 */

public class Exemplo1 {
    public static void main(String[] args) {

        // nesse caso é uma String, mas poderia ser uma classe qualquer
        Set<String> nomes = new HashSet<>();

        System.out.println("Adicionando 'azul': " + nomes.add("azul"));
        System.out.println("Adicionando 'amarelo': " + nomes.add("amarelo"));

        // não é possível adicionar valores iguais
        System.out.println("Tentar adicionar 'azul' de novo: " + nomes.add("azul"));


        // De resto os métodos são iguais do ArrayList (implementam a mesma interface)
        // .remove(), .add(), .contains(), .size(), .isEmpty(), .clear(), etc
        // Lembrando que os métodos que usam indice não funcionam pois a estrutura não
        // trabalha com indice.

        // Então, a única forma de percorrer é o for-each, não da para usar o for normal
        for(String nome : nomes) {
            System.out.println("Objeto: " + nome);
        }

    }
}
