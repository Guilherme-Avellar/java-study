package com.javarevisao.exercicios;

import java.util.Scanner;

public class Fibonacci_recursao {

    /**
     * Seguindo a ordem de Fibonacci: 1 1 2 3 5 8 13 21 34 55 89...
     * Usando a indução de f(n) = f(n - 1) + f(n - 2)
     * @param n representa a posição, não o valor. Por exemplo, a posição
     *          3 é o valor 2, a posição 7 é o valor 13.
     * @return retorna o valor da posição que se quer da sequencia de fibonacci
     */
    private static int fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int posicaoFibonacci = scanner.nextInt();

        System.out.println("Número de Fibonacci da posição: " + fibonacci(posicaoFibonacci));
    }
}

/*
    obs: na função a condição: if (n == 1 || n == 2), serve para a saída
    da recurção, mas também serve para retornar 1 quando se quer as posições
     1 e 2 da sequencia, sem fazer nenhuma recurção
 */
