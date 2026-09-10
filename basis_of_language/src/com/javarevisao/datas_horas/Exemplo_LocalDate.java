package com.javarevisao.datas_horas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Exemplo_LocalDate {

        public static void Exemplo_LocalDate() {
            // intanciando de LocalDate com .now() que pega a data atual
            LocalDate dataAtual = LocalDate.now();
            System.out.println("1 - " + dataAtual);

            LocalDate dataDeNascimento = LocalDate.of(1912, 6, 23);
            System.out.println("2 - " + dataDeNascimento.getDayOfMonth());

            // É possível receber em formato de STRING e passar direto para LocalDate com parse(), exemplo:
            String dataEmString = "2014-06-12";
            LocalDate dataCopa = LocalDate.parse(dataEmString);
            System.out.println("3 - " + dataCopa);


            // Para escolher o FORMATO de uma data:
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // OBS: se o formato que se quisesse converter fosse em dd-MM-yyyy, é so passar desta exata forma
            // para os parametros: .ofPattern("dd-MM-yyyy")
            System.out.println("4 - " + dataCopa);
            System.out.println("5 - " + dataCopa.format(formatter));
            // para motrar tudo escrito
            System.out.println("6 - " + dataCopa.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            //System.out.println("6 - " + dataCopa.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            // possui ainda o MEDIUM, SHORT

            // Obs: o .format(formatter) não altera a variavel. Para alterar teria que atribuir explicitamente.

            // Para receber uma data NÃO FORMATADA:
            dataEmString = "12/06/2014";
            LocalDate dataCopa2 = LocalDate.parse(dataEmString, formatter);
            // repare no segundo parametro do parse, o formatter
            System.out.println("7 - " + dataCopa2);

            // Para manipular, conseguir outra informação como a quantidade de tempo em tal data
            LocalDate dataNascimento1 = LocalDate.of(2020, 1, 1);
            LocalDate dataNascimento2 = LocalDate.of(2022, 1, 1);

            // somar anos
            LocalDate dataPara15anos = dataNascimento1.plusYears(11);
            System.out.println("8 - " + dataPara15anos);
            // somar dias
            System.out.println("9 - " + dataNascimento1.plusDays(11));

            System.out.println("\nidade1: " + dataNascimento1.format(formatter) + "\nidade2: " + dataNascimento2.format(formatter));
            // comparar datas
            System.out.println("idade1 vem antes de idade2: " + dataNascimento1.isBefore(dataNascimento2));
            System.out.println("idade1 vem depois de idade2: " + dataNascimento1.isAfter(dataNascimento2));
            System.out.println("idade1 é igual a idade2: " + dataNascimento1.isEqual(dataNascimento2));


            // IMPORTANTE: Para calcular periodo de tempo:
            LocalDate hoje = LocalDate.now();
            // Usa-se o Period, que é uma biblioteca:
            Period idade = Period.between(dataNascimento1, hoje);
            System.out.println("\nData de nascimento: " + dataNascimento1.format(formatter) + "\nidade: " + idade.getYears());
            // idade.getYears() retorna um int, o tempo em anos

        }
}
