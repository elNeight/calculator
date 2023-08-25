package org.example.parser.ast.impl.binary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.example.parser.ast.Expression;
import org.springframework.beans.factory.annotation.Value;

public class DivisionExpression implements Expression {

  private static final Integer scale = 10;

  private final Expression firstOperand;
  private final Expression secondOperand;

  public DivisionExpression(Expression firstOperand, Expression secondOperand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  @Override
  public BigDecimal evaluate() {
    return firstOperand.evaluate().divide(secondOperand.evaluate(), scale, RoundingMode.HALF_UP);
  }

}
