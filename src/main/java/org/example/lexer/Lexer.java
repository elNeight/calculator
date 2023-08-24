package org.example.lexer;

import java.util.List;
import org.example.lexer.model.Token;

public interface Lexer {

  List<Token> tokenize(String sequence);

}
