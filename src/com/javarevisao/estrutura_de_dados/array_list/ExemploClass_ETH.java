package com.javarevisao.estrutura_de_dados.array_list;

public class ExemploClass_ETH {
    String nome;
    float valor;

    public ExemploClass_ETH (float valor, String tipo) {
        this.valor = valor;
        this.nome = tipo;
    }


    public String getNome() {
        return nome;
    }
    public float getValor() {
        return valor;
    }

}
