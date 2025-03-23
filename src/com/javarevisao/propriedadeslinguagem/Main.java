package com.javarevisao.propriedadeslinguagem;

public class Main {
    public static void main(String[] args) {

        //TiposWrappers.vantagensWrapper();

        /*

        // instanciando para poder se usar o enum
        Enums e = Enums.MG;
        System.out.print("\n" + e.getNome());
        // pode instaciar pelo valor que o enum tem, exemplo
        String pegarEnum = "MG";
        // pega o enum de uma forma mais variavel
        Enums e2 = Enums.valueOf(pegarEnum);
        System.out.print("\n" + e2.getNome());
        // O enum também disponibiliza um metodo para pegar todos os objetos, .values()
        for(Enums e3: Enums.values()) {
            System.out.print("\n" + e3.getNome());
        }

        */


        // Exemplo de importação de uma classe feita manualmente:
        //PacotesVsImportacao.metodoImportado();

        // Funcionamento do .equals()
        EqualsVsIgual.distincoes();


    }
}
