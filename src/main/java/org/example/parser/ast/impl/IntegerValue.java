package org.example.parser.ast.impl;

import org.example.lexer.model.Token;
import org.example.parser.ast.Expression;

public class IntegerValue implements Expression {

  private final String value;

  public IntegerValue(Token token) {
    this.value = token.sequence();
  }

  @Override
  public Integer evaluate() {
    return Integer.parseInt(value);
  }

}
