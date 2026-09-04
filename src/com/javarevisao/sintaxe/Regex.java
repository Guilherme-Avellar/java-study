package com.javarevisao.sintaxe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    static void main(String[] args) {

        String texto = "meu email é guilherme@mail.com";
        Pattern padraoEmail = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher = padraoEmail.matcher(texto);

        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        String texto2 = "22999995555";
        Pattern padraoTelefone = Pattern.compile("(\\d{2})(\\d{4,5})(\\d{4})");
        matcher = padraoTelefone.matcher(texto2);

        if (matcher.matches()) {
            System.out.printf("(%s) %s-%s", matcher.group(1),
                    matcher.group(2), matcher.group(3));
        } else {
            System.out.println("número inválido");
        }

    }
}
