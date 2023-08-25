package org.example.parser.ast.impl;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.example.parser.ast.Expression;

@RequiredArgsConstructor
public class UnaryNegationExpression implements Expression {

  private final Expression operand;

  @Override
  public BigDecimal evaluate() {
    return operand.evaluate().negate();
  }

}
