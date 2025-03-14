package com.javarevisao.sintaxe;

public class TiposPrimitivos {

    // Números sem decimais

    // Armazena valores de -128 a 127. Usado para economizar memória. 8 bits
    byte byteQualquer = 100;

    // Armazena valores de -32.768 a 32.767. Também economiza memória, mas é pouco usado. 16 bits
    short shortQualquer = 32100;

    // Armazena valores de -2.147.483.648 a 2.147.483.647. É o tipo inteiro mais comum 32 bits
    int inteiroQualquer = 321000;

    // Armazena valores de -9 quintilhões a 9 quintilhões (-2^63 a 2^63-1). Usado quando int não é suficiente. 64 bits
    // OBS: Precisa do L ou l no final, caso o número tratado supere um inteiro. Pois Java usa int como padrão
    long longQualquer = 9000000000000000000L;



    // numeros flutuantes:

    // float (32 bits, precisão de ~7 dígitos)
    // Usa menos memória, mas tem menor precisão.
    // Precisa do F ou f no final do número, pois o java trata números decimais como double por padrão
    float floatQualquer = 2.5f;
    // Precisaria fazer o cast para não por o f ou F
    float floatQualquer2 = (float) 3.14;

    // double (64 bits, precisão de ~15 dígitos)
    // Padrão para números decimais devido à maior precisão.
    // Tratado como padrão para pontos flutuates pelo Java
    double doubleQualquer = 2.5;


    // Lógico:
    // Bolean, 1 bit
    boolean boolQualquer = true;


    // Caracteres:

    // Armazena um único caractere Unicode (ex.: 'A', '9', '\n'). 16 bits
    // OBS: Precisa ser declarado com aspas simples ''
    char charQualquer = 'A';

    // String não é considerado um tipo primitivo em Java, mas sim uma classe, que pertence ao
    // java.lang, possui métodos, etc...
    // OBS: Precisa ser declarado em aspas duplas ""
    String strQualquer = "Hello World";


    // OBS FINAL: Números com _ são permitidos para melhor legibilidade, mas sem começar/terminar com _
    // Exemplo:
    int numeroComEspacos = 2_000_000;


    /*
    Algumas palavras reservadas:

        Controle de fluxo: if, else, switch, case, default, while, do, for, break, continue, return

        Declaração de classes e métodos: class, interface, enum, extends, implements, abstract, final,
        static, void, this, super

        Modificadores de acesso: public, private, protected

        Tipos e valores: byte, short, int, long, float, double, char, boolean, true, false, null

        Tratamento de exceções: try, catch, finally, throw, throws

        Multithreading e sincronização: synchronized, volatile

        Outras: new, import, package, instanceof, native, strictfp, transient, assert, default,
        goto (não usado), const (não usado)

    */


}
