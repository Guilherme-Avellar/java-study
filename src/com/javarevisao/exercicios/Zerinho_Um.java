package com.javarevisao.exercicios;

import java.util.Scanner;

// Zerinho ou Um -- Neps Academy

public class Zerinho_Um {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        short A = scanner.nextShort();
        short B = scanner.nextShort();
        short C = scanner.nextShort();

        if(A == B && B == C){
            System.out.println("*");
        } else if(A == B){
            System.out.println("C");
        } else if(A == C){
            System.out.println("B");
        } else if(C == B){
            System.out.println("A");
        }

        scanner.close();
    }
}
