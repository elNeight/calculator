package org.example.parser.ast.impl.unary;

import static org.example.parser.constants.ExpressionConstants.PRECISION;

import java.math.BigDecimal;
import java.math.MathContext;
import lombok.RequiredArgsConstructor;
import org.example.parser.ast.Expression;

@RequiredArgsConstructor
public class SquareRootExpression implements Expression {

  private final Expression operand;

  @Override
  public BigDecimal evaluate() {
    return operand.evaluate().sqrt(new MathContext(PRECISION));
  }

}
