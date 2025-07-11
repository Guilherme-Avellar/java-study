package com.javarevisao.exercicios;

// https://neps.academy/br/exercise/384

import java.util.Scanner;

public class Fila_OBI2014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // pessoas na fila (inicialmente)
        scanner.nextLine();

        Fila filaPessoas = new Fila();
        Pessoa atual, anterior; // percorre a fila

        for (int i = 0; i < N; i++) {
            Pessoa novaP = new Pessoa();
            novaP.identificador = scanner.nextInt();
            novaP.proximo = null;

            if (filaPessoas.inicio == null) {
                filaPessoas.inicio = novaP;
                filaPessoas.fim = novaP;
            } else {
                filaPessoas.fim.proximo = novaP;
                filaPessoas.fim = filaPessoas.fim.proximo;
            }
        }

        int M = scanner.nextInt(); // pessoas que saíram
        scanner.nextLine();

        // remover
        for (int i = 0; i < M; i++) {
            int removerIdentificador = scanner.nextInt();

            atual = filaPessoas.inicio;
            anterior = filaPessoas.inicio;

            while(atual != null) {
                if (filaPessoas.inicio.identificador == removerIdentificador) {
                    filaPessoas.inicio = filaPessoas.inicio.proximo;
                } else if (atual.identificador == removerIdentificador) {
                    anterior.proximo = atual.proximo;
                    atual.proximo = null;
                    atual = anterior.proximo;

                    if(filaPessoas.fim.identificador == removerIdentificador)
                        filaPessoas.fim = anterior;
                } else {
                    anterior = atual;
                    atual = atual.proximo;
                }
            }
        }

        // exibir fila
        atual = filaPessoas.inicio;
        while (atual != null) {
            System.out.print(atual.identificador + " ");
            atual = atual.proximo;
        }
    }
    
    private static class Pessoa {
        int identificador;
        Pessoa proximo;
    }

    private static class Fila {
        Pessoa inicio = null;
        Pessoa fim = null;
    }
}

// Poderia ter sido usado o ArrayList, mas qual seria a graça?
