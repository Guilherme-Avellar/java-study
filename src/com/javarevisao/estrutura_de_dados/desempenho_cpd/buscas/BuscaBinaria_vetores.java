package com.javarevisao.estrutura_de_dados.desempenho_cpd.buscas;

import java.util.Arrays;


// Essa busca divide por 2 o indice do vetor a cada chcagem do valor.
// Usa-se o tamanho total do vetor e se vai ajustando os indices

// Uma das buscas mais eficientes em estruturas ordenadas

public class BuscaBinaria_vetores {

    private static int buscaBinaria(int[] vetor, int valor) {
        int posicao = -1;

        int i_baixo = 0;
        int i_medio;
        int i_alto = vetor.length -1;

        while(posicao == -1 && i_baixo <= i_alto){
            i_medio = (i_baixo + i_alto) / 2;
            if(valor == vetor[i_medio]) {
                posicao = i_medio;
            } else {
                if(valor < vetor[i_medio]) {
                    i_alto = i_medio -1;
                } else {
                    i_baixo = i_medio + 1;
                }
            }
        }

        // se retornar -1 é porque o valor não está no vetor
        return posicao;
    }

    public static void main(String[] args) {

        int[] vetorExemplo = {64, 34, 25, 12, 22, 11, 90};
        // a busca binária só funciona em estuturas ordenadas (nesse caso um vetor)
        Arrays.sort(vetorExemplo);

        System.out.println("Buscando o 25: " + buscaBinaria(vetorExemplo, 34));
        System.out.println("Buscando o 99: " + buscaBinaria(vetorExemplo, 99));
    }
}
