package org.example.lexer.impl;

import static java.lang.Boolean.FALSE;
import static org.example.lexer.model.TokenType.SPACE;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.example.lexer.Lexer;
import org.example.lexer.exception.UnexpectedSequenceException;
import org.example.lexer.model.Token;
import org.example.lexer.model.TokenType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SequenceTokenizer implements Lexer {

  private String sequence;
  private Integer sequenceCurrentPosition;
  private final EnumSet<TokenType> types = EnumSet.allOf(TokenType.class);

  private static final String START_OF_A_LINE = "^";

  @Override
  public List<Token> tokenize(String sequence) {

    assignSequence(sequence);
    List<Token> tokenList = new ArrayList<>();

    while (StringUtils.hasText(this.sequence)) {
      tokenList.add(extractToken());
    }

    return skipSpaces(tokenList);
  }

  private void assignSequence(String sequence) {
    this.sequence = sequence;
    sequenceCurrentPosition = 0;
  }

  private Token extractToken() {

    Pattern pattern;
    Matcher matcher;

    for (TokenType type : types) {

      pattern = Pattern.compile(START_OF_A_LINE + type.getRegexp());
      matcher = pattern.matcher(sequence);

      if (matcher.find()) {
        String matchedSequence = matcher.group();
        Integer matchedSequencePosition = sequenceCurrentPosition;
        Integer matchedSequenceLength = matchedSequence.length();
        sequence = sequence.substring(matchedSequenceLength);
        sequenceCurrentPosition = sequenceCurrentPosition + matchedSequenceLength;
        return new Token(matchedSequence, type, matchedSequencePosition);
      }

    }

    throw new UnexpectedSequenceException(sequenceCurrentPosition);
  }

  private List<Token> skipSpaces(List<Token> tokenListWithSpaces) {
    return tokenListWithSpaces.stream()
        .filter(token -> FALSE.equals(token.type().equals(SPACE)))
        .toList();
  }

}
