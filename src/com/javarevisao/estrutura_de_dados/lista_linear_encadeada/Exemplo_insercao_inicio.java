
package com.javarevisao.estrutura_de_dados.lista_linear_encadeada;

// OBS para ANTES do exemplo: Em java, a atribuição "=" com objetos, classes, arrays, é uma atribuição
// diferente do comum, essa atribuição passa a referencia de onde está o conteúdo e não o próprio
// conteúdo como de costume. Isso é uma mecânica da linguagem, Java cuida do gerenciamento da
// memoria para o programador.
// A instanciação de um objeto (ex: ObjExemplo obj = new ObjExemplo();), obj é um ponteiro para o
// conteúdo que a classe ObjExemplo constrói, como se fosse um ponteiro para uma struct em C. Esse
// ponteiro simboliza o nome, pois referencia o conteúdo, é usado para encontra-lo no código.

public class Exemplo_insercao_inicio {

    public static void exemplo() {

        // instancia de lista apontando para null, referenciando null
        No lista = null;

        // "lista" serve para ajustar as referencias do nó. Vai ser usada para "achar" a lista, e usada
        // para inserção


        // inserindo no inicio
        for(int i = 1; i < 4; i++) {
            No novo = new No(); // reutiliza "novo", explicação linha 48
            novo.dado = i * 5;
            novo.prox = lista;
            lista = novo;
        }

        /*      Explicando o exemplo

            Antes:
            lista -> null
            novo  -> [dado=5, prox=null]

            Depois de novo.prox = lista:
            lista -> null
            novo  -> [dado=5, prox=null]

            Depois de lista = novo:
            lista -> [dado=5, prox=null]
            novo  -> [dado=5, prox=null]
            (lista e novo apontam para o mesmo objeto)

         */

        /*      OBS para a variavel "novo" dentro do for linha 25:
            A variável é reutilizada dentro do escopo do loop. Mesmo que a declaração apareça em cada
            iteração, o Java trata isso como a mesma variável sendo reinicializada. `novo``No novo`
            No entanto, é importante notar que tecnicamente isso é uma redeclaração de variável,
            que só é permitida em Java porque cada iteração do loop cria um novo escopo. Isso é conhecido
            como "variable shadowing" em loops.
        */

        // obs: no final, lista referencia quem ela acabou de criar, sendo ela a referência usada para criar um
        // elemento na lista encadeada, fazendo com que ela sempre referencie o primeiro elemento da lista, essa
        // lógica que faz a inserção ser no inicio.

        // para exibir, se cria uma variavel auxiliar, para não alterar lista, pois ela é
        // usada para fazer a lista encadeada e localizar o primeiro elemento
        No aux = lista;
        while (aux != null) {
            System.out.println(aux.dado);
            aux = aux.prox;
        }

    }
}
