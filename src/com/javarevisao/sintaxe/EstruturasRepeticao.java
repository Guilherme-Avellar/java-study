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

        // OBS: O for pode ter mais de uma variavel sendo percorrida ao mesmo tempo:
        System.out.println("\n\nDuas variaveis de uma vez, i somando e j reduzindo até i < j");
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println(i + " - " + j);
        }
    }

    public static void estruturaForAprimorado () {

        // enhanced for ou for-each
        // Utilizado para percorrer arrays e coleções sem precisar de um índice manual.
        System.out.println("\nFor aprimorado 1 a 5 \nint num : numeros");
        int[] numeros = {1, 2, 3, 4, 5};
        for (int num : numeros) {
            System.out.println(num);
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
