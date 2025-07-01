package com.javarevisao.exercicios;

import java.util.Scanner;

// exercicio número 110, https://neps.academy/br/exercise/110

public class Consecutivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] todosNumeros = new int[N];

        for (int i = 0; i < N; i ++) {
            todosNumeros[i] = scanner.nextInt();
        }

        Contagem contagemPrincipal = new Contagem();
        int index = 0;

        while (index < (todosNumeros.length - 1)){
            if(todosNumeros[index] == todosNumeros[index + 1]) {
                Contagem contagemSecundaria = new Contagem();
                contagemSecundaria.valor = todosNumeros[index];

                while ((index < todosNumeros.length) && (todosNumeros[index] == contagemSecundaria.valor)) {
                    contagemSecundaria.sequencia++;
                    index++;
                }

                if(contagemSecundaria.sequencia > contagemPrincipal.sequencia) {
                    contagemPrincipal = contagemSecundaria;
                }
            } else
                index++;
        }

        System.out.println(contagemPrincipal.sequencia);
    }

    private static class Contagem {
        int sequencia = 0;
        int valor;
    }
}

/*
    Aparendizado do dia: A ordem da esquerda para direita é muito importante e básica,
    mas às vezes nos esquecemos dela. Neste problema eu estáva fazendo na linha 26:
    (todosNumeros[index] == contagemSecundaria.valor) && (index < todosNumeros.length)

    Ou seja, verificava o conteúdo do vetor primeiro, o que gerava um
    ArrayIndexOutOfBoundsException, só depois que eu inverti a ordem que funcionou:
    (index < todosNumeros.length) && (todosNumeros[index] == contagemSecundaria.valor)

    Porque aí já para a execução antes de se tentar acessar uma posição fora do vetor.
 */
