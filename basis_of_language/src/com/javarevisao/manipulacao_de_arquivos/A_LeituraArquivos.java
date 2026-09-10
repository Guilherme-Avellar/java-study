package com.javarevisao.manipulacao_de_arquivos;

// As classes usadas estão nos pacotes java.io e java.nio.file
import java.io.*;


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

/*
    Poderia ser feito a leitura de uma forma mais manual, criando um
    array do tipo byte e atribuir a ele o metodo File.readAllBytes(path);
    O path deve ser o caminho do arquivo.
    Depois passar o array de bytes do arquivo para string, o que resultara
    no conteúdo traduzido exemplo: String conteudo = new String(arrayByte);

    Porém ao invés disso, ha a possibilidade de usar apenas File.readString(path);
    que transforma o conteúdo inteiro em string sem ter que intermediar com
    esse vetor de bytes.

    Outra alternativa seria fazer uma coleção de todas as linhas apenas com
    o File, exemplo: List<String> linhas = Files.readAllLines(path);
    Sem usar o buffer dessa forma.
 */

/*
    Obs: é possível criar diretórios individualmente com mkdir()
    para 1 diretório ou mkdirs() para diretórios aninhados. Os dois
    métodos vem da classe File.
    Porém deve-se verificar se o diretório já existe, senão lança uma
    exceção. Exemplo de uso:
    File diretorio = new File("c:\\diretorioQualquer")
    if(!diretorio.exists())
        diretorio.mkdir();
 */
