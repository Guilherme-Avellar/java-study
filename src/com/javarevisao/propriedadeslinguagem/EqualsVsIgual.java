package com.javarevisao.propriedadeslinguagem;

public class EqualsVsIgual {

    public static void distincoes() {
        /*
        * Princiapal diferença:
        * "==" acessa diretamente o que está armazenado na memória e .equals() acessa o conteúdo.
        * O que está na memória pode ser diferente do conteúdo? SIM. O que pode estar na memória
        * é uma referência, e não o valor que se quer comparar, lembre-se que o esquema de referencias
        * (ponteiros do C) em Java é algo implícito, a linguagem não é tão liberal como o C para
        * manipulação de memória.
        *
        * Tipos primitivos armazenam valores diretamente na memória, porém, objetos usam esquemas
        * lógicos de referencia que precisam do .equals() para comparação em vez do "=="
        *
        * Resumindo:
        * Se usa == para comparar valores de tipos primitivos e para verificar se dois objetos são
        * a mesma instância na memória. Já .equals() deve ser usado para comparar o conteúdo de objetos.
        *
        * */

        String obj1 = new String("Java");
        String obj2 = new String("Java");

        System.out.println("\nObjetos diferentes, mas instanciados da mesma classe, comparados com: ");
        System.out.println(".quals() : " + obj1.equals(obj2));
        System.out.println("== : " + (obj1 == obj2));

    }

}
