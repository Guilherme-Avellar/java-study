package com.javarevisao.exercicios;

import java.util.Scanner;

public class Gincana_OBI2016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long M = scanner.nextLong();
        boolean condicao = true;

        while (condicao) {
            if (M == 1) {
                condicao = false;
            }else if ((N % M != 0) && isPrime(M)) {
                condicao = false;
            }else
                M -= 1;
        }
        System.out.println(M);
    }

    private static boolean isPrime(long number) {
        for (long i = number/2; i > 1; i--) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}


// N é o número de pessoas da turma rival e M é da sua turma

// N precisa ser primo e não pode ser igual ou dividir M
