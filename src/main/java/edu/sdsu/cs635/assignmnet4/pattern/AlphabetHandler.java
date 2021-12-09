package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler to match alphabetic characters
 */
public class AlphabetHandler extends AbstractPatternMatchHandler {

    protected AlphabetHandler(char charMatch) {
        super(charMatch);
    }

    @Override
    public boolean handle(PatternMatchRequest patternMatchRequest) {
        patternMatchRequest.incrementIndex();
        if (patternMatchRequest.isCurrentMatch(charMatch)) {
            return next.handle(patternMatchRequest);
        }else{
            return false;
        }
    }
}
