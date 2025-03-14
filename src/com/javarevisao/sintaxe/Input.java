package com.javarevisao.sintaxe;

// Para fazer um input no terminal, precisa-se dessa classe
import java.util.Scanner;

public class Input {

    // Precisa declarar o objeto que vai agir e fazer a leitura no terminal
    Scanner objScanner = new Scanner(System.in);

    public void scaniar() {

        System.out.println("Digite alguma coisa: ");

        // Usa o objeto declarado para ler o que foi escrito e atribuir a variavel
        String varaivelInput = objScanner.nextLine();

        System.out.println("Foi digitado: " + varaivelInput);
    }

    /*
        OBS: O Scanner muda de acordo com o tipo. nextLine() é usado para strings, mas
        deve-se usar outros para outros tipos, exemplo:

        .nextInt() para inteiro
        .nextDouble() para double

        etc...
    */

}




