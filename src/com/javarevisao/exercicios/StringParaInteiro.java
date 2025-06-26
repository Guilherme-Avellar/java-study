package com.javarevisao.exercicios;

import java.util.Scanner;

// Exercicio "inteiro de dois dígitos" do Neps Academy

public class StringParaInteiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.nextLine();
        String B = scanner.nextLine();

        int soma = Integer.parseInt(A + B);

        System.out.println(soma);
    }
}
