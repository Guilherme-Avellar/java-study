
// Pacote é necessário caso o arquivo esteja em uma subpasta da pasta raiz,
// no intellij, é preciso se criar pela ferramenta, para configurar a IDE
package com.javarevisao.sintaxe;

public class DeclaracaoSimplesObj {
    static int qtdInstancias = 0;

    public DeclaracaoSimplesObj() {
        qtdInstancias++;
        System.out.println("Objeto instanciado com sucesso!");
    }

    public void quantidadeInst () {
        System.out.println("Quantidade de objetos instanciados" + qtdInstancias);
    }
}
