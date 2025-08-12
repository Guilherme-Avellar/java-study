package com.javarevisao.exercicios;

import java.util.Scanner;

// Exercicio 268 https://neps.academy/br/exercise/268

public class SomaDeFracoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int C = scanner.nextInt();
        int D = scanner.nextInt();

        // A/B + C/D

        int dividendo, divisor;

        if (B == D) {
            dividendo = A + C;
            divisor = D;
        } else {
            divisor = mmc(B, D);
            A = (divisor / B) * A;
            C = (divisor / D) * C;
            dividendo = A + C;
        }

        // simplificar
        for (int i = 2; i <= divisor && i <= dividendo; i++) {
            while(dividendo % i == 0 && divisor % i == 0) {
                divisor /= i;
                dividendo /= i;
            }
        }

        System.out.print(dividendo + " " + divisor);
    }

    /**
     * Metodo usado nas escolas de ensino fundamental
     * @param B divisor da fração
     * @param D divisor da outra fração
     * @return retorna o minimo multiplo comum entre os dois números
     */
    private static int mmc(int B, int D) {
        int primo = 2;
        int minMultiplo = 1;

        while ( (B >= primo) || (D >= primo) ) {
            while (B % primo == 0 || D % primo == 0) {
                minMultiplo *= primo;

                if (B % primo == 0) {
                    B /= primo;
                }
                if (D % primo == 0) {
                    D /= primo;
                }
            }
            primo = proxPrimo(primo);
        }

        return minMultiplo;
    }

    /**
     * @param divisor número qualquer
     * @return retorna o próximo número primo que seja maior que o número passado
     */
    private static int proxPrimo(int divisor) {
        divisor++;
        for (int i = divisor - 1; i >= 2; i--) {
            if (divisor % i == 0) {
                divisor++;
                i = divisor;
            }
        }

        return divisor;
    }
}
