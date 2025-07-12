package com.javarevisao.exercicios;

// https://neps.academy/br/exercise/276

import java.util.Scanner;

// Ainda precisa de ajustes, a lógica de classificação não está certa

public class CopaDoMundo_OBI2010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] times = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'};

        char[] classificacao = new char[15];

        int golsEsquerda, golsDireita;
        int indiceTimes = 0;

        // montando uma arvore de 15 nós, com a raiz sendo o campeão
        for (int i = classificacao.length - 1; i >= 0; i--) {
            golsEsquerda = scanner.nextInt();
            golsDireita = scanner.nextInt();

            if (i >= 7) {
                if (golsEsquerda > golsDireita) {
                    classificacao[i] = times[indiceTimes];
                } else
                    classificacao[i] = times[indiceTimes + 1];
                indiceTimes += 2;
            } else {
                if (golsEsquerda > golsDireita) {
                    classificacao[i] = classificacao[i * 2 + 1]; // filho a esquerda
                } else
                    classificacao[i] = classificacao[i * 2 + 2]; // filho a direita
            }
        }

        System.out.println(classificacao[0]);
        scanner.close();
    }
}


// vetor que simula uma arvore, exemplo para teste
//  0,  1,   2,   3,   4,   5,   6    7    8    9   10
// {A, faB, faC, fbD, fbE, fcF, fcG, fdH, fdJ, feK, feL}

// Para achar os filhos:
// FilhoE = n * 2 + 1
// FilhoD = n * 2 + 2

// Para achar o nó pai
// PaiE = n / 2
// PaiD = n / 2 - 1

// se o indice inicial for zero, se arredonda o PaiE para baixo. Se o indice
// inicial for 1, arredonda o PaiD para cima.

// ou seja se o indice começa de zero, os filhos que estiverem em indice ímpar
// são "Filhos a Esquerda", e os pares "Filhos a Direita".

