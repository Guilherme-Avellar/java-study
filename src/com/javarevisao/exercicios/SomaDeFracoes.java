package com.javarevisao.exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exercicio 268 https://neps.academy/br/exercise/268

public class SomaDeFracoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int dividendo, divisor;
        // A/B + C/D

        if (D == B) {
            dividendo = A + C;
        }

        List<Integer> divisores = new ArrayList<>();
        int primo = 2;
        boolean condicao = true;

    }

    private static int nextPrime(int x) {
        x++;
        for (int i = x; i >= 2; i--) {
            if (x % i == 0) {
                x++;
                i = x;
            } else if (i == 2) {
                return x;
            }
        }

        return x;
    }
}


