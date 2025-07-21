package com.javarevisao.exercicios;

import java.util.Scanner;

public class Codigo_OBI2015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        int contador = 0;
        int[] valores = new int[N];

        for (int i = 0; i < N; i++) {
            valores[i] = scanner.nextInt();
        }

        for (int i = 0; i < N;) {
            if(valores[i] == 1) {
                i++;
                if(i < N && valores[i] == 0) {
                    i++;
                    if (i < N && valores[i] == 0) {
                        i++;
                        contador++;
                    }
                }
            } else
                i++;
        }

        System.out.println(contador);
    }
}
