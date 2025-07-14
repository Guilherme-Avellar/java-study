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

/*
    Outra forma de escrever em arquivos é usando apenas o File com metodo write, exemplo:
    Files.write(path, stringQualquer.getBytes(standardCharsets.UTF_8));
    faz o processo de transformar a string em bytes e passar para escrita, que interpreta
    os bytes normalmente, escrevendo o conteúdo no arquivo.
 */

/*
    É possível criar um arquivo "sem fazer nada nele" (para manipular depois etc.
    basta instanciar um objeto do File com o nome do arquivo e depois usar o metodo
    .createNewFile() nesse proprio objeto, mas pode lançar uma exceção caso já exista,
    então é necessário usar o try catch.
 */
