package com.javarevisao.exercicios;

import java.util.Scanner;

public class Gincana_OBI2016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long M = scanner.nextLong();
        boolean condicao = true;

        while (condicao) {
            if (calcularMDC(M, N) == 1)
                condicao = false;
            else
                M--;
        }

        System.out.println(M);
    }

    // Algoritmo de Euclides
    private static long calcularMDC(long x, long y) {
        while (y != 0) {
            long resto = x % y;
            x = y;
            y = resto;
        }
        return x;
    }
}

// N é o número de pessoas da turma rival e M é da sua turma