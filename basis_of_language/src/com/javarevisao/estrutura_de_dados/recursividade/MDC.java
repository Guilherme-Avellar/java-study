package com.javarevisao.estrutura_de_dados.recursividade;

// Máximo divisor comum, exemplo de funcionamento, MDC de 48 e 18:
//        48 ÷ 18 = 2 → resto 12
//        18 ÷ 12 = 1 → resto 6
//        12 ÷ 6 = 2 → resto 0    (quando o RESTO for ZERO o processo é parado)
// 6 é o maximo divisor comum de 48 e 18, ou seja, o maior divisor comum em que o resto é zero

public class MDC {

    private static int funcaoMDC(int m, int n) {
        if(n > m) {
            // troca de posição, para evitar erros de uso, m precisava ser o maior numero
            return funcaoMDC(n, m);
        } else if(n == 0) {
            return m;
        } else {
            return funcaoMDC(n, m % n);
        }
    }

    public static void main(String[] args) {
        System.out.println(funcaoMDC(48, 18));
        System.out.println(funcaoMDC(120, 160));
    }

}

/*
    Algoritmo de Euclides (mais eficiente e usado nesse exemplo)
    Funciona assim:

    Sejam dois números A e B, com A > B.

    Divida A por B e pegue o resto R.

    Substitua A por B e B por R.

    Repita até o resto ser zero.

    O último B ≠ 0 é o MDC.
 */
