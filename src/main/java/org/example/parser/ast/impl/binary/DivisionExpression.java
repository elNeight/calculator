package org.example.parser.ast.impl.binary;

import static org.example.parser.constants.ExpressionConstants.SCALE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import org.example.parser.ast.Expression;

@RequiredArgsConstructor
public class DivisionExpression implements Expression {

  private final Expression firstOperand;
  private final Expression secondOperand;

  @Override
  public BigDecimal evaluate() {
    return firstOperand.evaluate().divide(secondOperand.evaluate(), SCALE, RoundingMode.HALF_UP);
  }

}
