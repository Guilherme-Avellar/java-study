// Outra solução para outro exercício sobre a sequencia de Fibonacci

package com.javarevisao.exercicios;

import java.util.Scanner;

public class Fibonacci_sequecia {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        short N = scanner.nextShort();

        int atual = 1;
        int aux;
        int anterior = 0;

        for(int i = 1; i <= N; i++) {
            System.out.print(atual + " ");
            aux = atual;
            atual = atual + anterior;
            anterior = aux;
        }
    }
}
