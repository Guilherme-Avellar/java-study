package com.javarevisao.estrutura_de_dados.arvores;


public class arvoreBuscaBinaria {

    private static class Arvore {
        int dado;
        Arvore direita;
        Arvore esquerda;
    }

    // A mudança do Em Ordem para o Pré-Ordem e o Pós-ordem é o momento em que se
    // acessa o dado (arvore.dado). Pois como se trata de recurção, colocar antes
    // ou depois da chamada recursiva faz toda a diferença.

    // obs: coloca em ordem crescente
    private static void mostraEmOrdem(Arvore no){
        if (no != null) {
            mostraEmOrdem(no.esquerda);
            System.out.println(" "+ no.dado);
            mostraEmOrdem(no.direita);
        }
    }

    // obs: a raiz é a primeira a ser acessada
    private static void mostraPreOrdem(Arvore no){
        if (no != null) {
            System.out.println(" "+ no.dado);
            mostraPreOrdem(no.esquerda);
            mostraPreOrdem(no.direita);
        }
    }

    // obs: a raiz é a ultima a ser acessada
    private static void mostraPosOrdem(Arvore no){
        if (no != null) {
            mostraPosOrdem(no.esquerda);
            mostraPosOrdem(no.direita);
            System.out.println(" "+ no.dado);
        }
    }

    /* // minha primeira tentativa de fazer a inserção de ABB sem ver o material
    private static void preencher(Arvore no, int valor){

        if (valor >= no.dado) {
            if (no.direita != null)
                preencher(no.direita, valor);
            else {
                Arvore novo = new Arvore();
                no.direita = novo;
                novo.dado = valor;
            }
        }

        if (valor < no.dado) {
            if (no.esquerda != null)
                preencher(no.esquerda, valor);
            else {
                Arvore novo = new Arvore();
                no.esquerda = novo;
                novo.dado = valor;
            }
        }
    }
*/

    private static Arvore inserir(Arvore no, int valor) {
        // sempre que chegar em nó nulo irá inserir o valor
        if(no == null){
            no = new Arvore();
            no.dado = valor;
            no.esquerda = null;
            no.direita = null;
        } else if(valor < no.dado)
            no.esquerda = inserir(no.esquerda, valor);
            else
                no.direita = inserir(no.direita, valor);

        return no;
    }

    private static Arvore remove_valor (Arvore no, int valor) {
        if (no!=null){
            if(valor == no.dado){
                if (no.esquerda == null && no.direita==null)
                    //nó a ser removido é nó folha
                    return null;
                if (no.esquerda==null)
                    return  no.direita;
                    /*se não há subárvore esquerda o ponteiro passa apontar para a subárvore direita*/
                else{
                    if (no.direita==null)
                        /*se não há subárvore direita o ponteiro passa apontar para a subárvore
                        esquerda */
                        return no.esquerda;
                    else {
                        /*o nó a ser retirado possui subárvore esquerda e direita, então o nó que
                        será retirado deve-se encontrar o menor valor na subárvore à direita */
                        Arvore aux, ref;
                        ref = no.direita;
                        aux = no.direita;
                        while (aux.esquerda != null)
                            aux = aux.esquerda;
                        aux.esquerda = no.esquerda;
                        return ref;
                        // A JVM consegue ver que não há referencia para esse "no" e liberara memória
                        // automáticamente, se fosse em C, antes de retornar esse "ref" precisaria
                        // liberar memória com o free() para depois sair dessa etapa recursiva.
                    }
                }
            }
            else{		//procura dado a ser removido na ABB
                if(valor < no.dado)
                    no.esquerda = remove_valor(no.esquerda,valor);
                else
                    no.direita = remove_valor(no.direita,valor);
            }
        }
        return no;
    }

    public static void main(String[] args) {

        Arvore root = null;
        int[] vetor = {20, 18, 16, 19, 17, 22, 24, 100, 23};

        /* tentativa de usar a função que eu inventei (não está completamente correta)
        for(int i = 0; i < vetor.length; i++) {
            preencher(root, vetor[i]);
        }
        */

        for(int i = 0; i < vetor.length; i++) {
            root = inserir(root, vetor[i]);
        }


        mostraPreOrdem(root);
        System.out.println("\n");
        mostraEmOrdem(root);
        System.out.println("\n");
        mostraPosOrdem(root);

    }
}
