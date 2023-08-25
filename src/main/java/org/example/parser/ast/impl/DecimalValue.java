package org.example.parser.ast.impl;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.example.lexer.model.Token;
import org.example.parser.ast.Expression;

@RequiredArgsConstructor
public class DecimalValue implements Expression {

  private final String value;

  @Override
  public BigDecimal evaluate() {
    return BigDecimal.valueOf(Double.parseDouble(value));
  }

}
