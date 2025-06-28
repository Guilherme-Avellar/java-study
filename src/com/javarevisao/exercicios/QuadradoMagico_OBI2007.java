package com.javarevisao.exercicios;

import java.util.Scanner;

// Quadrado mágico, OBI 2007, Neps Academy 236

public class QuadradoMagico_OBI2007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] quadradoMagico = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                quadradoMagico[i][j] = scanner.nextInt();
            }
        }

        int somaQuadradoMagico = compararQuadradoMagico(quadradoMagico);

        System.out.println(somaQuadradoMagico);
    }

    private static int somarLinha(int[][] matriz, int linha) {
        int soma = 0;
        for(int j = 0; j < matriz.length; j++) {
            soma += matriz[linha][j];
        }
        return soma;
    }

    private static int somarColuna(int[][] matriz, int coluna) {
        int soma = 0;

        for(int i = 0; i < matriz.length; i++) {
            soma += matriz[i][coluna];
        }
        return soma;
    }

    private static int somarDiagonais(int[][] matriz) {
        int soma1 = 0, soma2 = 0;

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz.length; j++) {
                if (i == j)
                    soma1 += matriz[i][j];
                if ((i + j) == (matriz.length - 1))
                    soma2 += matriz[i][j];
            }
        }

        if (soma1 == soma2)
            return soma1;
        else
            return -1;
    }

    private static int compararQuadradoMagico(int[][] matriz) {
        int somaL = 0, somaC = 0;

        int somaReferencia = somarDiagonais(matriz);

        if (somaReferencia == -1) {
            return -1;
        }

        for (int i = 0; i < matriz.length; i++) {
            somaL = somarLinha(matriz, i);
            somaC = somarColuna(matriz, i);

            if ((somaL != somaReferencia) || (somaC != somaReferencia))
                return -1;
        }
        return somaReferencia;
    }

}

// Obs sobre a IDE IntelliJ:
// Copiar e colar a entrada da Run (alt + F4) funciona bem, porém, não tente
// alterar algo que já foi colado, pois não será reconhecido. A IDE ignora
// a alteração e mantêm o que foi colado.

