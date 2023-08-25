package org.example.parser.ast.impl.unary;

import static org.example.parser.constants.ExpressionConstants.PRECISION;

import java.math.BigDecimal;
import java.math.MathContext;
import org.example.parser.ast.Expression;

public class SquareRootExpression implements Expression {

  private final Expression operand;

  public SquareRootExpression(Expression operand) {
    this.operand = operand;
  }

  @Override
  public BigDecimal evaluate() {
    return operand.evaluate().sqrt(new MathContext(PRECISION));
  }

}
