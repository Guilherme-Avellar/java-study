package com.javarevisao.exercicios;
import java.util.Scanner;

public class Todos_Os_Divisores {

    private static void testarMultiplo(int number, int progrecao) {
        for (int i = 1; i <= number; i += progrecao) {
            if ((number % i) == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        // aumenta a performace, pois um número ímpar nunca será divisível por um numero par
        if((number % 2) == 0){
            testarMultiplo(number, 1);
        }else {
            testarMultiplo(number, 2);
        }
    }
}

// Exercicio do Neps Academy "Todos os Divisores"
