package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

/**
 * Common abstraction for all concrete handlers
 * specifies common data like next chain and character to be matched
 * specifies default method for setting the next handler.
 */
public abstract class AbstractPatternMatchHandler implements Handler<PatternMatchRequest> {
    protected Handler<PatternMatchRequest> next;
    protected char charMatch;

    /**
     * All Constructors for Abstract and Concrete Handlers are protected.
     * They must only be instantiated and accessed from the factory method in {@link Match} class
     *
     * @param charMatch is the current char in the pattern to be matched
     */
    protected AbstractPatternMatchHandler(char charMatch) {
        this.charMatch = charMatch;
        //initialize next with a default Null Handler that does nothing
        //so that you don't have to explicitly check null before invoking handle on the next handler instance
        this.next = new NullHandler();
    }

    /**
     * Common implementation to set next in chain handler for all concrete classes
     */
    @Override
    public void setNext(Handler<PatternMatchRequest> next) {
        this.next = next;
    }
}
