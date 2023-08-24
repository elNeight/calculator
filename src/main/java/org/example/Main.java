package org.example;

import java.util.List;
import org.example.config.SpringConfig;
import org.example.lexer.Lexer;
import org.example.lexer.model.Token;
import org.example.parser.Parser;
import org.example.parser.ast.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    Lexer lexer = context.getBean(Lexer.class);
    Parser parser = context.getBean(Parser.class);

    String sequence = "(2+2)*2";
    List<Token> tokenList = lexer.tokenize(sequence);

    tokenList.forEach(System.out::println);

    Expression expression = parser.parse(tokenList);

    System.out.println("Expression value is : " + expression.evaluate());

  }

}