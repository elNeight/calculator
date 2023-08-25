package org.example.parser.ast.impl.binary;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.example.parser.ast.Expression;

@RequiredArgsConstructor
public class MultiplicationExpression implements Expression {

  private final Expression firstOperand;
  private final Expression secondOperand;

  @Override
  public BigDecimal evaluate() {
    return firstOperand.evaluate().multiply(secondOperand.evaluate());
  }

}
