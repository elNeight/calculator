package org.example.parser.impl;

import static java.lang.Boolean.FALSE;
import static org.example.lexer.model.TokenType.ADDITION;
import static org.example.lexer.model.TokenType.DECIMAL_NUMBER;
import static org.example.lexer.model.TokenType.DIVISION;
import static org.example.lexer.model.TokenType.END_OF_A_SEQUENCE;
import static org.example.lexer.model.TokenType.INTEGER_NUMBER;
import static org.example.lexer.model.TokenType.LEFT_PARENTHESIS;
import static org.example.lexer.model.TokenType.MULTIPLICATION;
import static org.example.lexer.model.TokenType.RIGHT_PARENTHESIS;
import static org.example.lexer.model.TokenType.SUBTRACTION;

import java.util.List;
import org.example.lexer.model.Token;
import org.example.lexer.model.TokenType;
import org.example.parser.Parser;
import org.example.parser.ast.Expression;
import org.example.parser.ast.impl.DecimalValue;
import org.example.parser.ast.impl.IntegerValue;
import org.example.parser.ast.impl.binary.AdditionExpression;
import org.example.parser.ast.impl.binary.DivisionExpression;
import org.example.parser.ast.impl.binary.MultiplicationExpression;
import org.example.parser.ast.impl.binary.SubtractionExpression;
import org.example.parser.exception.UnexpectedTokenException;
import org.springframework.stereotype.Service;

@Service
public class TokenParser implements Parser {

  private List<Token> tokenList;
  private Integer listCurrentPosition;

  @Override
  public Expression parse(List<Token> tokenList) {
    assignTokenList(tokenList);
    return expression();
  }

  private Expression expression() {

    Expression firstOperand = term();

    while (FALSE.equals(getCurrentToken().type().equals(END_OF_A_SEQUENCE))) {
      if (match(ADDITION)) {
        listCurrentPosition++;
        firstOperand = new AdditionExpression(firstOperand, term());
      } else if (match(SUBTRACTION)) {
        listCurrentPosition++;
        firstOperand = new SubtractionExpression(firstOperand, term());
      } else {
        return firstOperand;
      }
    }

    return firstOperand;
  }

  private Expression term() {

    Expression firstOperand = factor();

    while (FALSE.equals(getCurrentToken().type().equals(END_OF_A_SEQUENCE))) {
      if (match(MULTIPLICATION)) {
        listCurrentPosition++;
        firstOperand = new MultiplicationExpression(firstOperand, factor());
      } else if (match(DIVISION)) {
        listCurrentPosition++;
        firstOperand = new DivisionExpression(firstOperand, factor());
      } else {
        return firstOperand;
      }
    }

    return firstOperand;
  }

  private Expression factor() {

    if (match(INTEGER_NUMBER)) {
      IntegerValue integerValue = new IntegerValue(getCurrentToken());
      listCurrentPosition++;
      return integerValue;
    } else if (match(DECIMAL_NUMBER)) {
      DecimalValue decimalValue = new DecimalValue(getCurrentToken());
      listCurrentPosition++;
      return decimalValue;
    } else {

      matchOrElseThrow(LEFT_PARENTHESIS);
      listCurrentPosition++;
      Expression expression = expression();
      matchOrElseThrow(RIGHT_PARENTHESIS);
      listCurrentPosition++;

      return expression;
    }

  }

  ////////

  private boolean match(TokenType type) {
    return tokenList.get(listCurrentPosition).type().equals(type);
  }

  private void matchOrElseThrow(TokenType type) {
    if (FALSE.equals(tokenList.get(listCurrentPosition).type().equals(type))) {
      throw new UnexpectedTokenException(tokenList.get(listCurrentPosition).position());
    }
  }

  private Token getCurrentToken() {
    return tokenList.get(listCurrentPosition);
  }

  ////////

  private void assignTokenList(List<Token> tokenList) {
    this.tokenList = tokenList;
    listCurrentPosition = 0;
  }

}
