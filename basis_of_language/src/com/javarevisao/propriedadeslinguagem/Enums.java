// É um tipo especial de classe. Enums são constantes de objetos
// Pode existe em outras linguagens como TypeScript

// É usado quando quando tem um número limitado e pequeno de informações a ser guardada,
// como os dias da semana, ou estados brasileiros, etc
// Algo que seja pequeno, limitado e que dificilmente irá mudar.

// Enums podem ter métodos como um objeto

package com.javarevisao.propriedadeslinguagem;

// Palavra reservada enum em vez de class
public enum Enums {

    // exemplo com os Estados Brasileiros

    // Declarando objetos imutáveis:

    PI ("Piaui"),
    MA ("Maranhão"),
    SP ("São Paulo"),
    RJ ("Rio de Janeiro"),
    MG ("Minas Gerais")
    ;

    private String nome;

    private Enums(String nome) {
        this.nome = nome;
    }

    // Repare que ele chama o construtor sendo declarado dentro da propria "classe"

    public String getNome() {
        return nome;
    }

    // Se usa o objeto com uma instância já pré-definida

    // OBS: São comparados com == e não com .equals(), já que são constantes únicas.
}
