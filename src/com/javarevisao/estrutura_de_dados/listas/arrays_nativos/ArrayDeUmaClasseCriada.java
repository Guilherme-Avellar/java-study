package com.javarevisao.estrutura_de_dados.listas.arrays_nativos;

import java.util.Scanner;

public class ArrayDeUmaClasseCriada {

    private static class ValorComposto {
        int numero;
        String texto;
    }

    public static void main(String[] args) {

        // Vetor comum
        int[] vetorComum = new int[4];


        // Há uma facilidade em criar vetores de outros tipos em Java,
        // diferentemente do C que se deve alocar memória dinamicamente.
        // Para isso se usa classes, exemplo:
        ValorComposto[] vetorCriado = new ValorComposto[4];

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < vetorCriado.length; i++) {

            // precisa instanciar cada posição antes de ser usado
            vetorCriado[i] = new ValorComposto();

            System.out.print("Digite um numero: ");
            vetorCriado[i].numero = scanner.nextInt();

            // para consumir o \n deixado pelo nextInt()
            scanner.nextLine();

            System.out.print("Digite um texto: ");
            vetorCriado[i].texto = scanner.nextLine();
        }

        for(int i = 0; i < vetorCriado.length; i++) {
            System.out.println("\n\nIndice: " + i);
            System.out.println("Numero: " + vetorCriado[i].numero);
            System.out.println("Texto: " + vetorCriado[i].texto);
        }

    }
}
