package org.example;

import java.util.List;
import org.example.config.SpringConfig;
import org.example.lexer.Lexer;
import org.example.lexer.model.Token;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    Lexer lexer = context.getBean(Lexer.class);

    String sequence = "  (2+    2) *2";
    List<Token> tokenList = lexer.tokenize(sequence);

    tokenList.forEach(System.out::println);

  }

}