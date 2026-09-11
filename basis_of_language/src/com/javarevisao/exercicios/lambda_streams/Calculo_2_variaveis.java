package com.javarevisao.exercicios.lambda_streams;

public class Calculo_2_variaveis {

    @FunctionalInterface
    interface Operacao {
        int exec(int a, int b);
    }

    static int calcular(int a, int b, Operacao op) {
        return op.exec(a, b);
    }

    static void main(String[] args) {
        System.out.println(calcular(6, 3, (a, b) -> a + b));
        System.out.println(calcular(6, 3, (a, b) -> a - b));
        System.out.println(calcular(6, 3, (a, b) -> a * b));
        System.out.println(calcular(6, 3, (a, b) -> Math.powExact(a, b)));
    }
}
