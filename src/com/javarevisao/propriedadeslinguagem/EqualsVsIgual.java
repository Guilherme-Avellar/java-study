package com.javarevisao.propriedadeslinguagem;

public class EqualsVsIgual {

    public static void distincoes() {
        /*
        * Princiapal diferença:
        * "==" acessa diretamente o que está armazenado na memória e .equals() acessa o conteúdo.
        * O que está na memória pode ser diferente do conteúdo? SIM. O que pode estar na memória
        * é uma referência, e não o valor que se quer comparar, lembre-se que o esquema de referencias
        * (ponteiros do C) em Java é algo implícito, a linguagem não é tão liberal como o C para
        * manipulação de memória.
        *
        * Tipos primitivos armazenam valores diretamente na memória, porém, objetos usam esquemas
        * lógicos de referencia que precisam do .equals() para comparação em vez do "=="
        *
        * Resumindo:
        * Se usa == para comparar valores de tipos primitivos e para verificar se dois objetos são
        * literalmente os mesmos na memória. Já .equals() deve ser usado para comparar o conteúdo dos objetos,
        * se equals() for sobreescritos, com override.
        * No caso de não sobrescrever o equals(), o Java ainda usa o comportamento padrão da classe Object,
        * que também compara referências. Ou seja, se você não sobrescrever equals(), ele vai funcionar da
        * mesma maneira que o ==.
        * OBS: O overrride do equals é tão padrão que a IDE já faz altomáticamente se o programador desejar.
        * Tipos Wrappers sobrescrevem o iquals() nativamente, para comparar valores, mas isso não é
        * regra para todos os objetos e classe que você encontrar por aí.
        * */

        // exemplo de funcionamento
        String obj1 = new String("Java");
        String obj2 = new String("Java");
        // Observação para mecânica Java do tipo wrapper: se o valor passado for o mesmo, a classe economisa
        // memória e coloca as instâncias de mesmo valor para referenciar-lo. Por isso eu não fiz da forma
        // tradicional: String obj =  "Java"; Obriguei a criar duas instancias desta forma

        System.out.println("\nObjetos diferentes, mas instanciados da mesma classe, comparados com: ");
        System.out.println(obj1 + ".quals() : " + obj1.equals(obj2));
        System.out.println(obj2 + "== : " + (obj1 == obj2));

        // Porém explicitamente atribuir um objeto a igualdade == será verdadeira
        TiposWrappers tp = new TiposWrappers();
        TiposWrappers tp2 = new TiposWrappers();
        System.out.println("\nObjetos de mesma classe mas instancias diferentes, comparados com ==: " + (tp == tp2)); // false
        // Agora quando atribuirmos a mesma instancia?
        TiposWrappers tp3;
        tp3 = tp;
        System.out.println("\nObjetos de mesma classe e mesma instancia, comparados com ==: " + (tp == tp3));


    }

}
