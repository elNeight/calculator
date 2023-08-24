package org.example;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.lexer.Lexer;
import org.example.lexer.model.Token;
import org.example.parser.Parser;
import org.example.parser.ast.Expression;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorImpl implements Calculator {

  private final Lexer lexer;
  private final Parser parser;

  public Number calculate(String sequence) {

    List<Token> tokenList = lexer.tokenize(sequence);
    Expression expression = parser.parse(tokenList);

    return expression.evaluate();
  }

}
