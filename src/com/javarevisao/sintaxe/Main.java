package com.javarevisao.sintaxe;

public class Main {
    public static void main(String[] args) {
        // Exemplo de instanciação de obj
        DeclaracaoSimplesObj obj1 = new DeclaracaoSimplesObj();
        obj1.quantidadeInst();

        // exemplo input
        Input input1 = new Input();
        //input1.scaniar();

        // exemplo funções
        Funcoes objFuncao = new Funcoes();
        System.out.print("Duas Strings concatenada por função: " + objFuncao.retorno2Strings("Hello ", "World"));

    }
}
