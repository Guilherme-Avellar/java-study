package com.javarevisao.manipulacao_de_arquivos;

import java.io.IOException;
import java.nio.file.*;

public class C_ListandoArquivos {
    public static void main(String[] args) {
        // objeto para representar o diretório
        Path dir = Paths.get("src/com/javarevisao/manipulacao_de_arquivos");

        // tenta abrir esse diretório, ou seja o objeto 'stream' guarda todos os
        // arquivos desse diretorio. É como se guardasse uma pasta dentro de uma
        // variavel.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){

            // percorrendo todos os arquivos que estão em stream, e mostrando seus nomes
            for (Path arquivo : stream) {
                System.out.println(arquivo.getFileName());
            }
        }catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
