package com.javarevisao.manipulacao_de_arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class F_ObterDadosArquivos {
    public static void main(String[] args) {

        Path arquivo = Paths.get("teste1.txt");
        try {
            BasicFileAttributes atributosArquivo = Files.readAttributes(arquivo, BasicFileAttributes.class);
            System.out.println("Tamanho em bytes: " + atributosArquivo.size());
            System.out.println("Data de criação: " + atributosArquivo.creationTime());
            System.out.println("Última modificação: " + atributosArquivo.lastModifiedTime());
            System.out.println("É um diretório?: " + atributosArquivo.isDirectory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
