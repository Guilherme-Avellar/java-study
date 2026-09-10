package com.javarevisao.sintaxe;

public class Funcoes {

    // Deve se dizer qual o tipo do parametro, além de se dizer o tipo de retorno da função, igual ao C
    public static int retornoIntQuadrado (int a) {
        return a * a;
    }

    // essa por exemplo não retorna nada, tipo void
    public static void funcaoJava (int a, double b, char c, String d) {
        System.out.println("inteiro: " + a + ", double: " + b + ", char: " + c + ", String: " + d);
    }

    // Retorna uma String. Pode retornar uma classe, aí coloca-se o nome da classe, como por exemplo String.
    public static String retorno2Strings (String a, String b) {
        return a + b;
    }

}
