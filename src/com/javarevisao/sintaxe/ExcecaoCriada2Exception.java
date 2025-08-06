package com.javarevisao.sintaxe;

// Exemplo de criação de exceção do tipo Exception, ou seja, precisam ser
// tradadas com try-catch ou declaradas com throws

public class ExcecaoCriada2Exception extends Exception {
  public ExcecaoCriada2Exception() {
    super("Mensagem da exceção do tipo Exception criada manualmente");
  }
}
