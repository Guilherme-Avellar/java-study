package com.javarevisao.propriedadeslinguagem;

// Como se manipular Strings em Java. Lembrando que String é uma classe em Java.
// Possui uma série de metodos que podem ser usados na manipulação.

import java.time.LocalDate;

public class ManipularStrings {
    public static void main(String[] args) {
        // Começando do mais básico para o mais complexo

        // concatenar Strings
        String nome = "João";
        String saudacao = "Olá, " + nome + "!";
        System.out.println(saudacao);

        // tamanho da String
        System.out.println(nome.length());

        // converter para maiuscula ou minuscula
        System.out.println(nome.toUpperCase());
        System.out.println(nome.toLowerCase());

        // comparar Strings
        String a = "Java";
        String b = "java";
        System.out.println(a.equals(b)); // false
        System.out.println(a.equalsIgnoreCase(b)); // true

        // verificar se existe uma certa substring
        String frase = "Aprendendo Java é divertido";
        System.out.println(frase.contains("Java")); // true

        // Criar uma substring
        String linguagem = "JavaScript";
        String sub = frase.substring(0, 4);
        System.out.println(sub); // Java

        // substituir parte da String
        frase = "Eu gosto de Python";
        String novaFrase = frase.replace("Python", "Java");
        System.out.println(novaFrase); // Eu gosto de Java

        // remover espaços extras
        String entrada = "  Olá mundo!  ";
        System.out.println(entrada.trim()); // "Olá mundo!"

        // dividir Strings
        String nomes = "Ana,Bruno,Carlos";
        String[] lista = nomes.split(",");
        for (String n : lista) {
            System.out.println(n);
        }

        // converter número para Strings e vice-versa
        int numero = 42;
        String texto = String.valueOf(numero);
        System.out.println(texto);
        String str = "123";
        int n = Integer.parseInt(str);
        System.out.println(n + 1);

        // Como usar Expressões em Java ======================

        // format. É parecido com o C
        String nome2 = "guilherme backham";
        int matricula = 123;
        double salario = 2000.541;
        String dadosFuncionario = String.format("nome: %s, mat: %d, sal: %f",
                nome2, matricula, salario);
        // no format existem: s de String, d de , f de valores flutuantes, t do tipo Date ou DateTime
        System.out.println(dadosFuncionario);
        // Há a possíbilidade de por parâmetros também, como o exemplo da precisão de decimais %.2f, poderia
        // ser outras precisões como %.3f, %.4f. E poderia ser outros parâmetros
        // Exemplo de formatações
        // minimo de trinta espaços para a String, autocompletar espaços faltantes do int com zero caso não tem 6
        // espaços e exibir apenas duas casas do pondo flutuante
        dadosFuncionario = String.format("nome: %30s, mat: %06d, sal: %.2f",
                nome2, matricula, salario);
        System.out.println(dadosFuncionario);
        // invertendo onde começa os espaçamentos vazios
        dadosFuncionario = String.format("nome: %-30s, mat: %06d, sal: %.2f",
                nome2, matricula, salario);
        System.out.println(dadosFuncionario);
        // definindo o tamanho mínimo e máximo da String. Se for maior será cortada no espaço máximo
        dadosFuncionario = String.format("nome: %-12.12s, mat: %06d, sal: %.2f",
                nome2, matricula, salario);
        System.out.println(dadosFuncionario);
        // Para trabalhar com datas no format
        LocalDate dataAdmicao = LocalDate.now();
        dadosFuncionario = String.format("Dia: %td, Mes: %tm, Ano: %ty", dataAdmicao, dataAdmicao, dataAdmicao);
        System.out.println(dadosFuncionario);
        // o sinal de < indica para usar o mesmo argumento, evitando repetições
        dadosFuncionario = String.format("Dia: %td, Mes: %<tm, Ano: %<ty", dataAdmicao);
        System.out.println(dadosFuncionario);
        // os simbolos do LocalDate também funcionam
        dadosFuncionario = String.format("Dia: %tD, Mes: %<tm, Ano: %<tY", dataAdmicao);
        System.out.println(dadosFuncionario);

    }
}

// Obs: a sintaxe "Object ... args" é um argumento que passa a combinação
// de objetos, é chamdo de varax. Forma uma espécie de array implícito de
// objetos, que é criado e preenchido em tempo de execução.
