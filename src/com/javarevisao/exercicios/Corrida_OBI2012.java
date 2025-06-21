package com.javarevisao.exercicios;

import java.util.Scanner;

public class Corrida_OBI2012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int C = scanner.nextInt(); // distancia a percorrer
        int N = scanner.nextInt(); // comprimento da pista
        int pontoFinal = 0;

        for (int i = 0; i < C; i++) {
            pontoFinal++;
            if(pontoFinal == N)
                pontoFinal = 0;
        }

        System.out.println(pontoFinal);
    }
}
