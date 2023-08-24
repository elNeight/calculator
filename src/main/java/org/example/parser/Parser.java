package org.example.parser;

import java.util.List;
import org.example.lexer.model.Token;
import org.example.parser.ast.Expression;

public interface Parser {

  Expression parse(List<Token> tokenList);

}
