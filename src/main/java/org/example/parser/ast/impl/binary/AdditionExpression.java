package org.example.parser.ast.impl.binary;

import org.example.parser.ast.Expression;

public class AdditionExpression implements Expression {

  private final Expression firstOperand;
  private final Expression secondOperand;

  public AdditionExpression(Expression firstOperand, Expression secondOperand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  @Override
  public Number evaluate() {
    return firstOperand.evaluate().doubleValue() + secondOperand.evaluate().doubleValue();
  }

}
