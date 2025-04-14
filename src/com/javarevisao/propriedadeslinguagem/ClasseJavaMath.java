package com.javarevisao.propriedadeslinguagem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClasseJavaMath {
    public static void exemplo() {

        // BigDecimal: usado para operações matemáticas que exigem mais precisão
        // Exemplo com valores financeiros
        BigDecimal valor1 = new BigDecimal("10.00");
        BigDecimal valor2 = new BigDecimal("3.00");
        // Divisão com precisão e arredondamento
        BigDecimal resultado = valor1.divide(valor2, 2, RoundingMode.HALF_UP);
        System.out.println("Resultado da divisão: " + resultado); // Saída: 3.33
        /*
        Se você usasse double, o resultado da divisão poderia ser 3.333333..., com
        perda de controle sobre casas decimais e possíveis erros em aplicações
        financeiras. Com BigDecimal, você define exatamente quantas casas decimais
        e como arredondar.
         */


    }
}
