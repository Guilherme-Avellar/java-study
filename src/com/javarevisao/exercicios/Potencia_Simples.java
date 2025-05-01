package com.javarevisao.exercicios;

import java.util.Locale;
import java.util.Scanner;

// Locale.US, nesse caso, faz números decimais serem exibidos com "." em vez de ","
// O Java segue o padrão da localidade, como está no Brasil ele usa por padrão ",". Usando
// o Locale.US força o Java a usar a nomenclatura americana

public class Potencia_Simples {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float x, y;

        x = scanner.nextFloat();
        y = scanner.nextFloat();

        if((0 <= x && x <= 10000) && (1.0 <= y && y <= 10.0)){
            double resultado = Math.pow(x, y);

            if(resultado <= Math.pow(10, 9))
                System.out.printf(Locale.US,"%.4f", resultado);
        }
    }
}

// Exercicio do neps academy
// OBS: o neps não está aceitando essa solução por algum motivo
