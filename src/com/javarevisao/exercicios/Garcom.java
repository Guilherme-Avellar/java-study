package com.javarevisao.exercicios;

import java.util.Scanner;

public class Garcom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int L, C, coposQuebrados = 0;

        for(int i = 1; i <= N; i++) {

            L = scanner.nextInt();
            C = scanner.nextInt();

            if(L > C) {
                coposQuebrados += C;
            }
        }
        System.out.println(coposQuebrados);
    }
}
