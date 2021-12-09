package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handles the first alphabet in pattern chain
 */
public class RootAlphabetHandler extends AbstractPatternMatchHandler {

    protected RootAlphabetHandler(char a) {
        super(a);
    }

    @Override
    public boolean handle(PatternMatchRequest patternMatchRequest) {
        for (int i = 0; i < patternMatchRequest.length(); i++) {
            if (patternMatchRequest.isCharAt(charMatch, i)) {
                patternMatchRequest.setCurrentCharIndex(i);
                if (next.handle(patternMatchRequest)) {
                    patternMatchRequest.setFirstMatchFoundAt(i);
                    return true;
                }
            } else {
                patternMatchRequest.incrementIndex();
            }
        }
        patternMatchRequest.setFirstMatchFoundAt(-1);
        return false;
    }
}
