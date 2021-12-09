package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler for first "." wildcard
 */
public class RootDotHandler extends AbstractPatternMatchHandler {

    protected RootDotHandler() {
        super('.');
    }

    @Override
    public boolean handle(PatternMatchRequest patternMatchRequest) {
        for (int i = 0; i < patternMatchRequest.length(); i++) {
            if (next.handle(patternMatchRequest)) {
                patternMatchRequest.setFirstMatchFoundAt(i);
                return true;
            }
        }
        patternMatchRequest.setFirstMatchFoundAt(-1);
        return false;
    }
}
