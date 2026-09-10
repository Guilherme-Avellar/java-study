package com.javarevisao.estrutura_de_dados.desempenho_cpd.ordenacao;

// O menos eficiente, mas é o código mais simples

public class BubbleSort {

    private static void ordenar(int[] vetor) {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 1; i < vetor.length; i++) {
                // Compara elementos adjacentes
                if (vetor[i - 1] > vetor[i]) {
                    // Troca os elementos de lugar
                    int temp = vetor[i - 1];
                    vetor[i - 1] = vetor[i];
                    vetor[i] = temp;
                    houveTroca = true; // Indica que uma troca ocorreu
                }
            }
        } while (houveTroca); // Continua enquanto houver trocas
    }

    public static void main(String[] args) {
        int[] vetorExemplo = {64, 34, 25, 12, 22, 11, 90};

        ordenar(vetorExemplo);
        System.out.println("Vetor ordenado:");
        for (int i = 0; i < vetorExemplo.length; i++) {
            System.out.print(vetorExemplo[i] + " ");
        }
    }
}
