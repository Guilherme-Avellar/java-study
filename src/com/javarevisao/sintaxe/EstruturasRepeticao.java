package com.javarevisao.sintaxe;

import java.util.Scanner;

public class EstruturasRepeticao {

    public static void estruturaFor () {
        System.out.println("\nContgem de 0 a 9, pulando o 3 e parando no 5");

        for (int i = 0; i < 10; i++) {
            // Caso esse if seja verdadeiro pula a próxima intrução, nesse caso o print
            if (i == 3) {
                continue;
            }

            System.out.println(i);

            // Quando o i chegar a 5 será interrompido, mesmo o for dizendo que é para parar no 10
            if (i == 5) {
                break;
            }
        }
    }

    // Mesmo código do for, mas traduzido para o while
    public static void estruturaWhile () {
        System.out.println("\nContgem de 0 a 9, pulando o 3 e parando no 5");

        int contador = 0;
        while (contador < 9) {

            if (contador == 3) {
                continue;
            }

            System.out.println(contador);

            if (contador == 5) {
                break;
            }
            contador++;
        }
    }

    public static void estruturaDoWhile () {
        Scanner sc = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Digite um número positivo (ou -1 para sair): ");
            numero = sc.nextInt();
            System.out.println("Você digitou: " + numero);

        } while (numero != -1);

        sc.close();
    }

}
