package com.javarevisao.exercicios;

import java.util.Scanner;

public class OrdenacaoSimples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] vetorN = new int[N];

        for (int i = 0; i < N; i++) {
            vetorN[i] = sc.nextInt();
        }

        int aux;
        for (int i = 0; i < N; i++) {
            for (int j = (N - 1); j > i; j--) {
                if (vetorN[i] > vetorN[j]) {
                    aux = vetorN[i];
                    vetorN[i] = vetorN[j];
                    vetorN[j] = aux;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(vetorN[i] + " ");
        }
    }
}


// Para um metodo mais eficiente (porém mais demorado de se implementar): Quick Sort
/*
    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1); // esquerda do pivô
            quickSort(vetor, posicaoPivo + 1, fim);    // direita do pivô
        }
    }

    // Particionamento usando o pivô como último elemento
    public static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // pivô = último elemento
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] < pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }

        trocar(vetor, i + 1, fim); // coloca o pivô na posição correta
        return i + 1;
    }

    // Troca de elementos
    public static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
*/
