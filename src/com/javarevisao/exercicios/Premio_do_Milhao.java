package com.javarevisao.exercicios;

import java.util.Scanner;

// Exercicio com uso do while com duas lógicas para saída, mais o uso do mesmo scanner repetidamente.

public class Premio_do_Milhao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int contadorViews = 0;
        int somaDias = 0;
        int A;

        while((contadorViews < 1000000) && (somaDias < N)) {
            A = scanner.nextInt();
            contadorViews += A;
            somaDias++;
        }

        System.out.println(somaDias);

    }
}

// Exercicio do Neps Academy
