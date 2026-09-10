package com.javarevisao.estrutura_de_dados.recursividade;

public class Fatorial {

    private static int funcaoFatorial(int n) {
        if(n != 0)
            return ( n * funcaoFatorial(n -1) );
        else
            return 1;
    }

    public static void main(String[] args) {

        System.out.println(funcaoFatorial(7));

    }
}
