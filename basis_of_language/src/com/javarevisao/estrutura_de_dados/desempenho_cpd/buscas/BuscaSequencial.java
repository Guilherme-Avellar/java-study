package com.javarevisao.estrutura_de_dados.desempenho_cpd.buscas;

import java.util.Scanner;
import java.util.Random;

// É utilizada em listas (ou outra estrutura) ordenadas, guarda valores junto com seu
// indice em intervalos para tornar a busca mais rápida. Depois de ter os valores espaçados
// verifica se o valor buscado está no intervalo espaçado, se estiver basta procurar o indice
// correspondente do valor dentro desse intervalo na estrutura original.


// Por exemplo: Um vetor ordenado de 10.000 posições, para tornar a busca de um elemento dentro
// desse vetor mais rápida, cria-se dois vetores, um com o valor do indice e outro com o elemento
// correspondido do original, só que "pulando" de 100 em 100 os indices. Sendo assim, a busca ve
// primeiro os dois vetores criados, analizando os intervalos de 100 em 100 dos indices guardados,
// se encontrar, colhe o indice e busca no vetor original começando por tal indice. Seria como
// buscar em um vetor de 100 posições no espaçado + 100 do intervalo do original, no pior dos
// casos é uma busca em 200 posições

public class BuscaSequencial {

    // subconjunto é o espaçamento, exemplo subconjunto 4 = buscar de 4 em 4, 10 = 10 em 10 etc

    private void buscar(int subConjunto, int[] vetor, int valor) {
        int i;

        // criando a "tabela de indices" (os dois vetores)
        int j = subConjunto;
        int n = vetor.length / subConjunto;
        int[] k_indice = new int[n];
        int[] v_indice = new int[n];

        // fazendo os vetores com os "espaçamentos"
        for(i = 0; i < n; i++) {
            k_indice[i] = vetor[j-1]; // guarda o valor
            v_indice[i] = j-1; // guarda o indice
            j = j + subConjunto; // faz o espacamento de subConjunto em subConjunto
        }

        // para ler as estremidades dos espaçamentos (subConjunto)
        int low, hi;

        // Para encontrar o sub-conjunto que valor pode estar:
        for(i = 0; i < n && k_indice[i] < valor; i++);


        if (i == 0)
            low = 0;
        else
            low = v_indice[i - 1];
        if (i == n)
            hi = v_indice.length - 1;
        else
            hi = v_indice[i];

        // agora que já se achou o valor no sub-conjunto, se busca no vetor original
        // o valor percorrendo apenas o tamanho do sub-conjunto

        j = low;
        while(j < hi && vetor[j] != valor)
            j++;

        if (j<hi)
            System.out.println("\nChave encontrada na posicao: " + j);
        else
            System.out.println("\nChave não encontrada");
    }

    public static void main(String[] args) {


    }
}
