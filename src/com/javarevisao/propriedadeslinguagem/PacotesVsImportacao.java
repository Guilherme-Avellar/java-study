
/*
    Pacotes:
    Servem para organizar o código. Um pacote é um agrupamento lógico de classes
    e interfaces que facilita a organização e evita conflitos de nomes.

    Importações:
    Servem para trazer uma classe que está em um pacote diferente. Trazendo a
    funcionalidade desta classe para este progrma mesmo não estando no mesmo pacote
*/
package com.javarevisao.propriedadeslinguagem;

// import de uma classe que foi feita manualmente em um outro pacote
import com.javarevisao.sintaxe.Operadores;

public class PacotesVsImportacao {

    public static void metodoImportado() {
        System.out.println("\nClasse Operadores, com import para outro pacote:");
        Operadores.operadoresRe();
    }

}
