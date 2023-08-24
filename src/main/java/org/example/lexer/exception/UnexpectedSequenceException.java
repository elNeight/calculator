package org.example.lexer.exception;

public class UnexpectedSequenceException extends RuntimeException {

  private static final String UNEXPECTED_SEQUENCE_EXCEPTION = "Unexpected sequence at position '%s'";

  public UnexpectedSequenceException(Integer position) {
    super(String.format(UNEXPECTED_SEQUENCE_EXCEPTION, position));
  }

}
