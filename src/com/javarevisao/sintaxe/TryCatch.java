package com.javarevisao.sintaxe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {


    // Exceção simples, pegando qualquer tipo de erro (não recomendado)
    public static void excecoesSimples() {

        Scanner sc = new Scanner(System.in);

        String nome = "";

        // "try" tenta executar o bloco, caso contrario, vai para o próximo bloco catch
        try {
            System.out.println("Digite seu nome: ");
            nome = sc.nextLine();

            // Exception é uma classe em Java, que representa todas as exceções, todos os erros recuperáveis. O Java
            // possui classes para cada tipo de exceção
        } catch (Exception e) {
            System.err.println("Ocorreu um erro");

            // lembrando: o finally executa sempre, idependente de erro ou não
        } finally {
            sc.close();
        }

        int idade = 0;
        try {
            System.out.print("Digite sua idade: ");
            idade = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro");

        } finally {
            sc.close();
        }

        System.out.println("Nome digitado: " + nome);
        System.out.println("Idade digitado: " + idade);

    }


    // Além das exceções manuais, existem as automáticas, que acontecem com frequencia
    // em métodos prontos do Java
    public static boolean excecoesManAut() {
        Scanner sc = new Scanner(System.in);

        int idade;
        String nome;

        try {
            System.out.print("Digite seu nome: ");
            nome = sc.nextLine();
            // Exceção feita manualmente, com throw
            if(nome.length() < 3) {
                throw new IllegalArgumentException("Nome inválido, é muito curto");
            }

            System.out.print("Digite sua idade: ");
            idade = sc.nextInt();
            // O metodo nextInt() do scanner lança uma exceção (throw) automática quando é digitado algo
            // que não seja um int, a exceção é a InputMismatchException.

            // Exceção feita manualmente, do nome invalido
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;

            // exceção automática passada pelo nextInt() do Scanner
        } catch (InputMismatchException e) {
            System.err.println("Idade passada é invalida");
            return false;

            // fecha o scanner idependente do resultado
        } finally {
            sc.close();
        }

        System.out.println("Nome digitado: " + nome);
        System.out.println("Idade digitada: " + idade);

        return true;
    }

    // O ideal para um código robusto é fazer um try separado para cada coisa específica e um catch para cada erro.

    // Não um try para todas as entradas, pois fica dificil saber qual lugar que deu o tal problema, mesmo com um catch
    // para cada erro. Nem um catch para todas as entradas e erros, pois fica dificil saber onde aconteceu o erro e
    // qual erro acontenceu.

    // Vai gerar mais repetição de código, porém o programa fica mais legível e robusto, de fácil manutenção:
    public static void excecoesIdeais() {
        Scanner sc = new Scanner(System.in);
        int idade;
        String nome;

        try {
            System.out.print("Digite sua idade: ");
            idade = sc.nextInt();

            // O sc.nextLine() após o nextInt() evita que a quebra de linha interfira no próximo nextLine().
            // para caso o scanner seja reutilizado
            sc.nextLine();

            if(idade >= 0 && idade < 18) {
                throw new IllegalArgumentException("Proíbido para menores de 18 anos\n");
            } else if (idade < 0 || idade > 150) {
                throw new IllegalArgumentException("Idade digitada incorretamente (inferior a 0 ou maior que 150)\n");
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            sc.close();
            // para parar a execução do médoto
            return;

        }catch (InputMismatchException e) {
            System.err.println("Não foi digitado um número");
            sc.close();
            return;
        }

        try {
            System.out.print("Digite seu nome: ");
            nome = sc.nextLine();

            // se nome não for vazio mas menor que 3
            if(!nome.isEmpty() && nome.length() < 3) {
                throw new IllegalArgumentException("Nome inválido, é muito curto");
            } else if (nome.isEmpty()) {
                throw new IllegalArgumentException("Não foi digitado um nome");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return;
        } finally {
            sc.close();
        }

        System.out.println("Nome digitado: " + nome);
        System.out.println("Idade digitada: " + idade);

        // repare que IllegalArgumentException está sendo tratado duas vezes mas de formas diferentes.
    }

    // É possível criar uma Exceção para um problema específico. Não são nada menos que classes
    public static void excecoesCriadasManualmente(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite algo: ");
        String algo = sc.nextLine();
        System.out.print("Digite algo novamente: ");
        String algo2 = sc.nextLine();

        // Exemplo de exceção de RuntimeException (não presisam de try-catch, mas pode usar)
        exemploException(algo);

        try {
            // precisa usar try-catch para chamar essa função, pois ela pode lançar uma exceção do tipo Exception
            exemploException2(algo);
        } catch (ExcecaoCriada2Exception e) {
            System.err.println(e.getMessage());

        // Sempre se começa com os catchs de Exceções específicas para depois tratar as mais gerais.
        // Não se pode usar o Exception antes, pois ele abranje o ExcecaoCriada2Exception que foi criado manualmente.
        } catch (Exception e) {
            System.out.println("Lembre-se de seguir a hierarquia de exceções");
        }
    }

    // A palavra-chave throws serve para avisar ao compilador e ao programador que
    // o metodo pode lançar tal exceção
    private static void exemploException(String algo) throws ExcecaoCriadaException{
        if(!algo.equals("a")) {
            throw new ExcecaoCriadaException();
        }
    }

    private static void exemploException2(String algo) throws ExcecaoCriada2Exception{
        if(!algo.equals("b")) {
            throw new ExcecaoCriada2Exception();
        }
    }
}
