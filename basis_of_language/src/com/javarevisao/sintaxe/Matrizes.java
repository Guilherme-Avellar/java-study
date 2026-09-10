package com.javarevisao.sintaxe;

public class Matrizes {
    public static void main(String[] args) {

        // Declaração de uma matriz 2x2 simples de inteiros
        int[][] matrizExemplo = new int[2][2];

        // para atribuir valores manualmente:
        int[][] matrizDiretaExemplo = {{5, 7}, {13, 17}};

        // é parecido com um array mesmo, já que uma matriz é um vetor de vetores

        // para percorrer
        for(int i = 0; i < matrizDiretaExemplo.length; i++) {
            for(int j = 0; j < matrizDiretaExemplo[i].length; j++) {
                System.out.println("indices "+"["+i+"]"+"["+j+"]"+ " = " + matrizDiretaExemplo[i][j]);
            }
        }

        // preenchendo a matriz vazia
        for(int i = 0; i < matrizExemplo.length; i++) {
            for(int j = 0; j < matrizExemplo[i].length; j++) {
                matrizExemplo[i][j] = (i - j) * 4 + j;
            }
        }
        System.out.println("\n\n");
        for(int i = 0; i < matrizExemplo.length; i++) {
            for(int j = 0; j < matrizExemplo[i].length; j++) {
                System.out.println("indices "+"["+i+"]"+"["+j+"]"+ " = " + matrizExemplo[i][j]);
            }
        }
    }
}
