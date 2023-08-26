package org.example.parser.ast.impl.unary;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.example.parser.ast.Expression;

@RequiredArgsConstructor
public class NaturalLogarithm implements Expression {

  private final Expression operand;

  @Override
  public BigDecimal evaluate() {
    return BigDecimal.valueOf(Math.log(operand.evaluate().doubleValue()));
  }

}
