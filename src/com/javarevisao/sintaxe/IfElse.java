package com.javarevisao.sintaxe;

public class IfElse {

    public static void condicionais (int nota) {
        System.out.println("\nCondicionais com nota: " + nota);

        if (nota >= 90) {
            System.out.println("Aprovado com excelência!");
        } else if (nota >= 70) {
            System.out.println("Aprovado.");
        } else if (nota >= 50) {
            System.out.println("Recuperação.");
        } else {
            System.out.println("Reprovado.");
        }

    }

}
