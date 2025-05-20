package com.javarevisao.estrutura_de_dados.desempenho_cpd.buscas;

public class ExemplosBuscasSimples {

    // busca a quantidade de ocorrencias do valor dentro do vetor bd
    private int buscaSequencialExaustiva(int[] bd, int valor, int[] encontrados) {
        int i, ne = 0;
        for(i = 0; i < bd.length; i++) {
            if(bd[i] < valor) {
                encontrados[i] = bd[i];
                ne++;
            }
        }

        // quantidade de registros encontrados
        return ne;
    }

    // achar a posição que se está um valor dentro de um vetor
    private int buscaSequencial(int[] bd, int valor) {
        int posicao = -1;
        for(int i = 0; i < bd.length && posicao == -1; i++) {
            if(bd[i] == valor)
                posicao = i;
        }

        // se retornar -1 é porque não achou o valor dentro do vetor
        return posicao;
    }

    public static void main(String[] args) {

    }
}
