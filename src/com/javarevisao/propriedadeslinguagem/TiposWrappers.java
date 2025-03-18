package com.javarevisao.propriedadeslinguagem;

public class TiposWrappers {

    /*
        Tipos wrappers são classes para se instanciar objetos
        que irão representar tipos primitivos.

        É útil quando se quer uma "variavel" mais flexivel, como
        transformar um inteiro em string. Os wrappers proporcinam
        métodos para manipulação do valor
    */

    public static void vantagensWrapper() {

        // int é dito como Integer
        Integer i = 100000;

        // char é dito como Character
        Character c = 'A';

        // O resto é apenas com a inicial maíuscula
        Byte b = 127;
        Short s = 32000;
        Long l = 10000000000L;
        Float f = 3.14f;
        Double d = 2.71828;
        Boolean bool = true;

        // Antigamente precisava se converter o valor para o objeto antes de atribuir
        // a um wrapper. Depois do Java 5, isso passou a ser automático, exemplo de
        // como era:
        int numero = 10;
        Integer numeroWrapper = Integer.valueOf(numero); // Encapsulando (Boxing)
        int numero2 = numeroWrapper.intValue(); // Recuperando o valor (Unboxing)

        // A IDE dá até o alerta de "unnecessary unboxing". Dizendo que não é necessário

        System.out.println("Byte como inteiro: " + b.intValue() + 0);

        System.out.println("Short para String: " + s.toString());

        System.out.println("Integer binário: " + Integer.toBinaryString(i));

        System.out.println("Long como double: " + l.doubleValue());

        System.out.println("Float arredondado: " + Math.round(f));

        System.out.println("Double formatado: " + String.format("%.2f", d));

        System.out.println("É letra? " + Character.isLetter(c));

        bool = Boolean.TRUE;
        System.out.println("Boolean como string: " + bool.toString());

        // Há varias outras vantagens como métodos famosos de objetos como array list
        // etc...
    }

}
