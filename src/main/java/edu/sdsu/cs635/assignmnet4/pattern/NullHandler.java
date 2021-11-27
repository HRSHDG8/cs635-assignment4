package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

/**
 * Null Object Pattern implementation of {@link Handler} interface
 * Used at end of request chain to avoid null check before invoking handle method
 */
public class NullHandler implements Handler<Request> {

    @Override
    public void setNext(Handler<Request> next) {

    }

    @Override
    public boolean handle(Request request) {
        return true;
    }
}
