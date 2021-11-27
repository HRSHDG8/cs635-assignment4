package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

/**
 * Common abstraction for all concrete handlers
 * specifies common data like next chain and character to be matched
 * specifies default method for setting the next handler.
 */
public abstract class AbstractRequestHandler implements Handler<Request> {
    protected Handler<Request> next;
    protected char charMatch;

    /**
     * All Constructors for Abstract and Concrete Handlers are protected.
     * They must only be instantiated and accessed from the {@link RequestHandlerFactory}
     *
     * @param charMatch is the current char in the pattern to be matched
     */
    protected AbstractRequestHandler(char charMatch) {
        this.charMatch = charMatch;
        //initialize next with a default Null Handler that does nothing
        //so that you don't have to explicitly check null before invoking handle on the next handler instance
        this.next = new NullHandler();
    }

    @Override
    public void setNext(Handler<Request> next) {
        this.next = next;
    }
}
