package com.javarevisao.estrutura_de_dados.listas.array_list;

import java.util.ArrayList;
import java.util.List;

// O tamanho é dinâmico (principal vantagem) e é uma lista de apenas 1 tipo classe

public class Exemplo_ArrayList {

    private static class ValorComposto{
        int numero;
        String nome;
    }

    public static void main(String[] args) {

        // O ArrayList segue o seguinte padrão:
        // List<ClasseQualquer> nomeDaLista = new ArrayList<>()
        List<String> lista1 = new ArrayList<>();

        // Esse <> depois do List é chamado de Generics. Que é onde se decide
        // o tipo de dado que será armazenado na lista. Nesse caso, String.
        // Muitas outras coleções usam o Generics, como Map, Set, etc...

        // adicionando elementos
        lista1.add("Azul");
        lista1.add("Amarelo");
        lista1.add("Vermelho");
        lista1.add("Roxo");
        lista1.add("Vermelho");

        // Formato da lista em print puro
        System.out.println("\nFormato da lista em print puro: " + lista1 + "\n");

        // Para consultar um valor pelo indice. Lembrando: sempre começa no zero
        System.out.println("Valor no indice 1: " + lista1.get(1));

        // Para modificar um elemento da lista. (indice, novo valor)
        lista1.set(0, "AzulModificado");

        System.out.println("Valor modificado, indice 0: " + lista1.get(0));


        // para saber o tamanho da lista usa-se .size()
        System.out.println("Tamanho da lista: " + lista1.size());
        // para pegar o indice de um valor
        System.out.println("Posição de Vermelho: " + lista1.indexOf("Vermelho"));
        // como tem dois Vermelho na lista, ele vai pegar a primeira ocorrencia

        // para remover um item,
        lista1.remove("Vermelho");
        // pode ser passado o indice também

        // O que é repetido e vem depois permanece ou os dois são removidos?
        System.out.println("Posição de Vermelho depois de remover repetido: " + lista1.indexOf("Vermelho"));
        // permanece na posição

        // adicionando um elemento em um indice especifico
        lista1.add(1, "CorAdicionada");
        // O que acontece com Amarelo que estava no indice 1, onde CorAdicionada foi adicionado?
        System.out.println("Adicionado CorAdicionada no indice 1. Indice CorAdicionada: "
                + lista1.indexOf("CorAdicionada") + " Indice Amarelo: " + lista1.indexOf("Amarelo"));
        // É passado para frente, vai para o indice 2

        // Para ver se existe um valor especifico dentro da lista
        if(lista1.contains("Roxo"))
            System.out.println("Existe Roxo dentro de lista\n\n");

        // Para percorrer
        for (Object o : lista1) {
            System.out.println(o);
        }

        /*// ou pode ser feito manualmente
        for(int i = 0; i < lista1.size(); i++)
            System.out.println(lista1.get(i));
         */

        // Para limpar a lista
        lista1.clear();

        // Para ver se está vazia
        if(lista1.isEmpty())
            System.out.println("\nA lista está fazia");
    }
}
