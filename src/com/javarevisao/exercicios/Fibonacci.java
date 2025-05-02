package com.javarevisao.exercicios;

import java.util.Scanner;

public class Fibonacci {

    private static int acharValorFibonacci(int n) {

        int valor = 1;
        int valorAnterior = valor;

        for(int i = 1; i <= n; i++) {
            valorAnterior = valor - valorAnterior;
            valor = valor + valorAnterior;
        }
        return valor;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // posição do valor que se quer da sequencia de Fibonacci
        int N = scanner.nextInt();

        System.out.println(acharValorFibonacci(N));
    }
}
/*
     Magicamente, essa solução funciona com uma mecânica inusitada nos dois
     primeiros laços do loop, se ajustando automaticamente com o tempo:

     valorAnterior: 1 - 1 = 0
     valor: 1 + 0 = 1

     valorAnterior: 1 - 0 = 1
     valor: 1 + 1 = 2

     valorAnterior: 2 - 1 = 1
     valor: 2 + 1 = 3

     valorAnterior: 3 - 1 = 2
     valor: 3 + 2 = 5

     valorAnterior: 5 - 2 = 3
     valor: 5 + 3 = 8

     etc...

     A sequencia de Fibonacci se baseia na soma dos dois numeros anteriores para gerar o próximo
     então o número atual é o resultado dos dois:
     f(n) = f(n-1) + f(n-2)

     Eu precisava encontrar e armazenar o valor de f(n-2) para usar no código, então eu fiz:

     f(n-1) = f(n-2) + f(n-3) ==========> f(n-2) = f(n-1) - f(n-3)

     ou seja:

     f(n-2) = f(n-1) - f(n-3) ==========> valorAnterior = valor - valorAnterior;
     f(n) = f(n-1) + f(n-2) ==========> valor = valor + valorAnterior;

     As variaveis foram reaproveitadas, "valor" fez o papel de f(n) e f(n-1).
     Agora "valorAnterior" faz o papel de f(n-2) e f(n-3).
*/
