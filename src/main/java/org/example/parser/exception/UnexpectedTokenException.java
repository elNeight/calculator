package org.example.parser.exception;

public class UnexpectedTokenException extends RuntimeException {

  private static final String UNEXPECTED_TOKEN = "Unexpected token at position '%s'";

  public UnexpectedTokenException(Integer position) {
    super(String.format(UNEXPECTED_TOKEN, position));
  }

}
