package com.javarevisao.exercicios;

import java.util.Scanner;

// https://neps.academy/br/exercise/271

public class Expressoes_medio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();

        String[] A = new String[T];

        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextLine();
        }
        for (String a : A) {
            verificarCadeiaCaracter(a);
        }


    }

    // poderia ser usado o StringBuilder, mas eu quis implementar lógica com String normal

    private static void verificarCadeiaCaracter(String A) {
        int i = 0;
        boolean condicao = true;

        // i + 1 pois o loop verifica dois indices de uma vez a cada laço
        while (condicao && (i + 1 < A.length())) {
            switch (A.charAt(i)) {
                case '(':
                    if(A.charAt(i + 1) == ')') {
                        A = A.substring(0, i) + A.substring(i + 2);
                        i = 0;
                    } else if(A.charAt(i) == '}' || A.charAt(i) == ']') {
                        condicao = false;
                    } else
                        i++;
                    break;
                case '{':
                    if(A.charAt(i + 1) == '}') {
                        A = A.substring(0, i) + A.substring(i + 2);
                        i = 0;
                    } else if(A.charAt(i) == ')' || A.charAt(i) == ']') {
                        condicao = false;
                    } else
                        i++;
                    break;
                case '[':
                    if(A.charAt(i + 1) == ']') {
                        A = A.substring(0, i) + A.substring(i + 2);
                        i = 0;
                    } else if(A.charAt(i) == '}' || A.charAt(i) == ')') {
                        condicao = false;
                    } else
                        i++;
                    break;
                default:
                    condicao = false;
                    break;
            }
        }
        if(A.isEmpty())
            System.out.println("S");
        else
            System.out.println("N");
    }
}

// Com certeza existe uma solução com recursividade que o código ficará
// bem mais limpo, porém, não consegui pensar a tempo, mas implementarei
// mais tarde. Resolve todos esses problemas:
// (((((((((({([])}])))))))))
// (({}[)])
// (([)])