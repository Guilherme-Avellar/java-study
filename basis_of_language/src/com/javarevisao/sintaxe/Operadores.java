package com.javarevisao.sintaxe;

public class Operadores {

    public static void operadoresRe() {
        System.out.println("\nOperadores Relacionais com 2 e 3: ");
        System.out.println("2 == 3: " + (2 == 3));
        System.out.println("2 != 3: " + (2 != 3));
        System.out.println("2 > 3: " + (2 > 3));
        System.out.println("2 < 3: " + (2 < 3));
        System.out.println("2 >= 3: " + (2 >= 3));
        System.out.println("2 <= 3: " + (2 <= 3));

    }

    public static void operadoresArit () {
        System.out.println("\nOperadores Aritméticos:");
        System. out.println("2 + 3 = " + (2 + 3));
        System. out.println("2 - 3 = " + (2 - 3));
        System. out.println("2 * 3 = " + (2 * 3));
        System. out.println("2 / 3 = " + (2 / 3));
        System. out.println("2 % 3 = " + (2 % 3));
        System. out.println("\nAs demais operações deve se usar a biblioteca math:");
        System.out.println("2 elevado a 3 = " + (Math.pow(2, 3)));
    }

    public static void operadoresUnit () {
        int x = 5;
        System.out.println("\nOperadores Unitários, com x = 5:\n");

        System.out.println("x++ = " + x++ + ". Valor de x na mesma linha: " + x);
        System.out.println("x na próxima linha de execução: " + x +"\n");

        System.out.println("++x = " + ++x + ". Valor de x na mesma linha: " + x);
        System.out.println("x na próxima linha de execução: " + x +"\n");

        System.out.println("x-- = " + x-- + ". Valor de x na mesma linha: " + x);
        System.out.println("x na próxima linha de execução: " + x +"\n");

        System.out.println("--x = " + --x + ". Valor de x na mesma linha: " + x);
        System.out.println("x na próxima linha de execução: " + x +"\n");

        System.out.println("-x (inverte o sinal) = " + -x);
        x = -x;

        System.out.println("\n+x (valor positivo redundante) = " + (+x));
        x = +x;

        System.out.println("\n~x (inverte os bits da memoria da variavel) = " + ~x);
        x = ~x;

        System.out.println("\nLógica de negação, !true = " + !true);

    }

    public static void operadoresLogi () {
        System.out.println("\nOperadores Logicos e ternario com x = 5, y = 7: ");
        int x = 5, y = 7;
        System.out.println("OR: x > 3 || y == 7: " + (x > 3 || y == 7));
        System.out.println("AND: x < 3 && y == 7: " + (x < 3 && y == 7));
        System.out.println("NOT: !(y == 7): " + !(y == 7));

        System.out.println("\nOperador ternário com x > y:");
        System.out.println((x > y) ? "x é maior" : "y é maior ou igual");

        // Regra geral para ternario
        // condicao ? valor_se_verdadeiro : valor_se_falso;
    }

}
