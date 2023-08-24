package org.example.parser.ast.impl.binary;

import java.math.BigDecimal;
import org.example.parser.ast.Expression;

public class AdditionExpression implements Expression {

  private final Expression firstOperand;
  private final Expression secondOperand;

  public AdditionExpression(Expression firstOperand, Expression secondOperand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  @Override
  public BigDecimal evaluate() {
    return firstOperand.evaluate().add(secondOperand.evaluate());
  }

}
