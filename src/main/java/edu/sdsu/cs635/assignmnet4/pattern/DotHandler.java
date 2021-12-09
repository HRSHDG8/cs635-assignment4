package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler for "." wildcard
 */
public class DotHandler extends AbstractPatternMatchHandler {

    protected DotHandler() {
        super('.');
    }

    @Override
    public boolean handle(PatternMatchRequest patternMatchRequest) {
        patternMatchRequest.incrementIndex();
        return next.handle(patternMatchRequest);
    }
}
