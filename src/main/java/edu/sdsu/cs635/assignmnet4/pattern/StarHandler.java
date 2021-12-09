package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler for "*" wildcard
 */
public class StarHandler extends AbstractPatternMatchHandler {

    public StarHandler(char charMatch) {
        super(charMatch);
    }

    @Override
    public boolean handle(PatternMatchRequest patternMatchRequest) {
        if (charMatch == ' ') {
            return true;
        } else {
            for (int i = patternMatchRequest.getCurrentCharIndex(); i < patternMatchRequest.length(); i++) {
                if (patternMatchRequest.isCharAt(charMatch, i)) {
                    // if next character matches the ith value set current char to (i - 1) and invoke next handler
                    patternMatchRequest.setCurrentCharIndex(i - 1);
                    if (next.handle(patternMatchRequest)) {
                        patternMatchRequest.setFirstMatchFoundAt(i);
                        return true;
                    }
                } else {
                    patternMatchRequest.incrementIndex();
                }
            }
        }
        return false;
    }
}
