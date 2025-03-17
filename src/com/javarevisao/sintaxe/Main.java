package com.javarevisao.sintaxe;

public class Main {
    public static void main(String[] args) {
        // Exemplo de instanciação de obj
        DeclaracaoSimplesObj obj1 = new DeclaracaoSimplesObj();
        //obj1.quantidadeInst();

        // exemplo input
        Input input1 = new Input();
        //input1.scaniar();

        // exemplo funções
        Funcoes objFuncao = new Funcoes();
        //System.out.print("Duas Strings concatenada por função: " + objFuncao.retorno2Strings("Hello ", "World"));

        // exemplo operadores aritmeticos
        Operadores objOp = new Operadores();
        //objOp.operadoresRe();

        // exemplo operadores relacionais
        //objOp.operadoresArit();

        // exemplo operadores unitários
        //objOp.operadoresUnit();

        // exemplo operadores logicos e ternario
        //objOp.operadoresLogi();

        // if else em cadeia
        IfElse objIf = new IfElse();
        //objIf.condicionais(70);

        // Exemplo de atribuição ternária
        String atTernaria = 3 > 5 ? "3 é maior que 5" : "3 não é maior que cinco";

        // exemplo switch case
        SwitchCase objSwitch = new SwitchCase();
        objSwitch.switchExpression(7);

    }
}
