package com.javarevisao.exercicios;
import java.util.Scanner;

public class Todos_Os_Divisores {

    // mais performace com number/2, pois nenhum número será divisível por um interiro
    // maior que a sua metade, a não ser ele mesmo, que é posto depois do loop
    private static void testarMultiplo(int number, int progressao) {
        for (int i = 1; i <= number/2; i += progressao) {
            if ((number % i) == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.print(number + " ");
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
