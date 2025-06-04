package com.javarevisao.manipulacao_de_arquivos;

// As classes usadas estão nos pacotes java.io e java.nio.file

// prepara um arquivo para ser manipulado
import java.io.*;
// uma classe para ler arquivos de texto, que lê caracteres
// aumenta a eficiencia de leitura e fornece metodos praticos para facilitar a leitura


public class A_LeituraArquivos {
    public static void main(String[] args) {

        // OBS: O `File` tem como ponto de referência o diretório raiz do
        // projeto e não o pacote onde o código está.
        File objetoArquivo = new File("teste1.txt");

        // FliReader é quem "abre" o arquivo
        try(FileReader lerArquivo = new FileReader(objetoArquivo);
            BufferedReader buffer1 = new BufferedReader(lerArquivo)) {

            // lendo linha por linha até acabar, disponibilizado pelo BufferReader
            String linha;
            while((linha = buffer1.readLine()) != null){
                System.out.println("\n" + linha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
    java.io.File: é para preparar um arquivo para ser manipulado
    java.io.FileReader: é para ler arquivos de texto, que lê caracteres
    java.io.BufferedReader: aumenta a eficiencia de leitura e fornece
    metodos práticos para facilitar a leitura
 */
