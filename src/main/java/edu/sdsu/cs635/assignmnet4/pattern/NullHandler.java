package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

/**
 * Null Object Pattern implementation of {@link Handler} interface
 * Used at end of request chain to avoid null check before invoking handle method.
 * Note : This class cannot extend {@link AbstractPatternMatchHandler} since it does not want default implementation of setNext()
 *        and {@link NullHandler} is instantiated in Constructor of {@link AbstractPatternMatchHandler} which would cause stackoverflow
 */
public class NullHandler implements Handler<PatternMatchRequest> {

    @Override
    public void setNext(Handler<PatternMatchRequest> next) {
        //do nothing
    }

    @Override
    public boolean handle(PatternMatchRequest patternMatchRequest) {
        return true;
    }
}
