package com.javarevisao.exercicios;

import java.util.Scanner;

public class Divisao_2casasDecimais {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double A = scanner.nextDouble();
        double B = scanner.nextDouble();

        double S = A/B;

        System.out.printf("%.2f", S); // igual ao C

        // Para algo mais complexo e preciso, pode-se usar o BigDecimal
    }
}
