package com.javarevisao.exercicios;
import java.util.Scanner;

public class Lampadas_interruptores {

    public static void interruptor1(boolean[] vetor) {
        vetor[0] = !vetor[0];
    }

    public static void interruptor2(boolean[] vetor) {
        vetor[0] = !vetor[0];
        vetor[1] = !vetor[1];
    }


    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        int N = 2;
        int n = 0;

        // [0] = A, [1] = B
        boolean[] lampadas = {false, false};

        N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            n = scanner.nextInt();

            if(n == 1) {
                interruptor1(lampadas);
            } else {
                interruptor2(lampadas);
            }
        }

        if (lampadas[0] == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        if (lampadas[1] == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}


/*
    Exercicio do Neps Academy https://neps.academy/br/exercise/52
 */
