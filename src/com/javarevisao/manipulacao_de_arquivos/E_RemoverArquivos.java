package com.javarevisao.manipulacao_de_arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E_RemoverArquivos {
    public static void main(String[] args) {

        String nomeArquivo = "teste1_Copiado.txt";

        try {
            Files.delete(Path.of(nomeArquivo));
            System.out.println("\nArquivo excluido com sucesso");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
