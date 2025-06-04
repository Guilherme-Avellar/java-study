package com.javarevisao.manipulacao_de_arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class B_EscritaArquivos {
    public static void main(String[] args) {

        // vetor de strings para colocar no arquivo
        List<String> listaNomes = Arrays.asList("alguma coisa 1", "outra coisa 2", "terceira coisa 3");

        // esse file writer é uma instacia que serve so para ser passado para o
        // BufferedWriter. O segundo parametro diz o que se tem que fazer caso o
        // arquivo exista. Nesse caso, append adiciona no final, caso exista
        try (BufferedWriter bufferedW = new BufferedWriter(new FileWriter("teste2.txt", true))) {

            // for-each que vai percorrer a lista de strings
            for(String linha: listaNomes) {
                // escreve o que esta no linha
                bufferedW.write(linha);
                // quebra uma linha, é o \n
                bufferedW.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
