package org.example.parser.ast.impl;

import java.math.BigDecimal;
import org.example.parser.ast.Expression;

public class UnaryNegationExpression implements Expression {

  private final Expression operand;

  public UnaryNegationExpression(Expression operand) {
    this.operand = operand;
  }

  @Override
  public BigDecimal evaluate() {
    return operand.evaluate().negate();
  }

}
