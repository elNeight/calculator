package org.example.lexer.model;

import lombok.Getter;

@Getter
public enum TokenType {

  /**
   * Operators
   */
  ADDITION("\\+"),
  SUBTRACTION("-"),
  MULTIPLICATION("\\*"),
  DIVISION("\\/"),

  /**
   * Operands
   */
  DECIMAL_NUMBER("((0\\.[0-9]+)|([1-9][0-9]*\\.[0-9]+))"),
  INTEGER_NUMBER("((0)|([1-9][0-9]*))"),

  /**
   * Parentheses
   */
  LEFT_PARENTHESIS("\\("),
  RIGHT_PARENTHESIS("\\)"),

  /**
   * Spaces
   */
  SPACE("\\s+"),
  END_OF_A_SEQUENCE("$");

  private final String regexp;

  TokenType(String regexp) {
    this.regexp = regexp;
  }

}
