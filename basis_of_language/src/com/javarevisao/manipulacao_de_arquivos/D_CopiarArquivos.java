package com.javarevisao.manipulacao_de_arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class D_CopiarArquivos {
    public static void main(String[] args) {

        try {
            Path origem = Paths.get("teste1.txt");
            Path destino = Paths.get("teste1_Copiado.txt");

            // copia de 'origem' para 'destino', se 'destino' já existir ele sobrescreve
            // com REPLACE_EXISTING, caso contrário é criado o arquivo de 'destino'
            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\nArquivo copiado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
