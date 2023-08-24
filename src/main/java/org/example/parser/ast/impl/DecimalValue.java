package org.example.parser.ast.impl;

import org.example.lexer.model.Token;
import org.example.parser.ast.Expression;

public class DecimalValue implements Expression {

  private final String value;

  public DecimalValue(Token token) {
    this.value = token.sequence();
  }

  @Override
  public Double evaluate() {
    return Double.parseDouble(value);
  }

}
