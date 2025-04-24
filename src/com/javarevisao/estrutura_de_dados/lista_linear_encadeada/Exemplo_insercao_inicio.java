
package com.javarevisao.estrutura_de_dados.lista_linear_encadeada;

public class Exemplo_insercao_inicio {

    public static void exemplo() {
        // "lista" serve para ajustar as referencias do nó. É usada para "achar" a lista, e é usada para inserção
        No lista = null;


        // inserindo no inicio
        No novo = new No();
        novo.dado = 5;
        novo.prox = lista;
        lista = novo;

        // obs: no final, lista referencia quem ela acabou de criar, sendo ela a referência usada para criar um
        // elemento na lista encadeada, fazendo com que ela sempre referencie o primeiro elemento da lista, essa
        // lógica que faz a inserção ser no inicio.

        // 8 passa a ser o primeiro elemento agora
        No novo2 = new No();
        novo2.dado = 8;
        novo2.prox = lista;
        lista = novo2;

        // Agora 13 passa a ser o primeiro elemento
        No novo3 = new No();
        novo3.dado = 13;
        novo3.prox = lista;
        lista = novo3;

        // para exibir, se cria uma variavel auxiliar, para não alterar lista, pois ela é
        // usada para fazer a lista encadeada
        No aux = lista;
        while (aux != null) {
            System.out.println(aux.dado);
            aux = aux.prox;
        }

    }
}
