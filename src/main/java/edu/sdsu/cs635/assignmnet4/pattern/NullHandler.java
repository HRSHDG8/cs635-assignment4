package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

public class NullHandler implements Handler<Request> {

    @Override
    public void setNext(Handler<Request> next) {

    }

    @Override
    public Handler<Request> next() {
        return new NullHandler();
    }

    @Override
    public boolean handle(Request request) {
        return true;
    }
}
