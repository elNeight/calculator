package org.example;

import org.example.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    Calculator calculator = context.getBean(Calculator.class);

    String sequence = "2 + 2 * 2";

    System.out.println(calculator.calculate(sequence));

  }

}