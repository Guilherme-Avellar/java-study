package com.javarevisao.sintaxe;

// Forma de se criar uma Exceção manualmente
// Está sendo usada na classe TryCatch

// Esse exemplo é do tipo RuntimeException, não precisam ser tratadas, caso não queira

public class ExcecaoCriadaException extends RuntimeException {
    // pode ser passado parametros para o construtor e manipula-los
    public ExcecaoCriadaException() {
      super("Mensagem de exceção criada manualmente do tipo RuntimeException");
    }
}
