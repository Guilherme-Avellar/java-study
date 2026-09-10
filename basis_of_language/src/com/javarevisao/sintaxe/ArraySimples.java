package com.javarevisao.sintaxe;

public class ArraySimples {

    public static void exemploArraySimples() {

        // Declaração básica:
        int[] vetor = new int[10];
        // arrai de 10 posições de valores int

        // Curiosidade: Caso não seja atribuido valor a um array de tipo primitivo como int, float, etc, o array será
        // preenchido com o valor zero

        // Com tipos wrappers
        Integer[] vetor2 = new Integer[10];

        // Preenchimento padrão
        vetor[0] = 11;
        vetor[1] = 9;

        vetor2[0] = 8;

        // .length diz o tamanho do array
        System.out.println(vetor.length); // 10
        // Muito usado em estruturas de repetição, mas usa-se .length -1, pois o array começa a indexação do zero

        // Para atribuir na propria declaração
        int[] vetor3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };






    }

}
