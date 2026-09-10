package com.javarevisao.propriedadeslinguagem;
import java.util.concurrent.atomic.AtomicBoolean; // Classe da biblioteca padrão

// Em java não existe as referencias explícitas como no C/C++, mas há formas
// de passar valores por referencia para as funcoes. Para isso se usa as classes

public class Funcoes_ParametrosPorReferencia {

    public static int valorExemplo = 0;

    // =============================== Funções para demontração de passagem por referencia:

    private static void trocar(AtomicBoolean a) {
        a.set(!a.get()); // Altera o valor
    }

    private static void incrementar(int[] arr) {
        arr[0] = arr[0] + 1;
    }

    private static void alterarClasse(Funcoes_ParametrosPorReferencia2 x) {
        x.valorExemplo = 10;
    }



    // =============================== Métodos para execução das funções:

    public static void exemploComWrappers() {
        // Precisa-se usar o Atomic, que é da biblioteca padrão do java. Os wrappers normais
        // são imutáveis por funções. Há varios outros, AtomicInteger etc...
        AtomicBoolean A = new AtomicBoolean(true);
        trocar(A);
        System.out.println("Wrapper: " + A.get()); // Saída: A = false
    }

    public static void exemploComArray() {
        // arrays em java possuem a mesma mecânica dos arrays em C, se comportam como ponteiros
        int[] valor = {5};
        incrementar(valor);
        System.out.println("vetor: " + valor[0]); // Saída: 6
    }

    public static void exemploClassesInstanciadas() {
        Funcoes_ParametrosPorReferencia2 v = new Funcoes_ParametrosPorReferencia2();
        alterarClasse(v);
        System.out.println("classe: " + v.valorExemplo);
    }

}
