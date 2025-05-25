package com.javarevisao.exercicios;

import java.util.Locale;
import java.util.Scanner;

// Exercício 184 do Neps Academy

public class ManoloCrypto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nDias = scanner.nextInt();

        double valorMoeda = scanner.nextDouble();
        double valorTotal = 100 * valorMoeda;
        double aux = valorTotal;

        for(int i = 0; i < nDias - 1; i++) {

            valorMoeda = scanner.nextDouble();
            valorTotal = 100 * valorMoeda;
        }

        System.out.printf(Locale.US,"%.2f", valorTotal - aux);

    }
}
