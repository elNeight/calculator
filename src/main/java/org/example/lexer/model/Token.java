package org.example.lexer.model;

public record Token(String sequence, TokenType type, Integer position) {

}