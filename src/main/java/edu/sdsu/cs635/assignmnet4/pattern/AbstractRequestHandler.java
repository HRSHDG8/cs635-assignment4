package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

public abstract class AbstractRequestHandler implements Handler<Request> {
    protected Handler<Request> next;
    protected char charMatch;

    public AbstractRequestHandler(char charMatch) {
        this.charMatch = charMatch;
        this.next = new NullHandler();
    }

    @Override
    public void setNext(Handler<Request> next) {
        this.next = next;
    }
}
