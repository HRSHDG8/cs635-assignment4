package edu.sdsu.cs635.assignmnet4;

import edu.sdsu.cs635.assignmnet4.handler.Handler;
import edu.sdsu.cs635.assignmnet4.pattern.Request;
import edu.sdsu.cs635.assignmnet4.pattern.RequestHandlerFactory;

public class Match {
    private final Handler<Request> handler;

    public Match(String pattern) {
        this.handler = RequestHandlerFactory.rootHandler(pattern);
        Handler<Request> temp = handler;
        for (int i = 1; i < pattern.length(); i++) {
            Handler<Request> nextHandler = RequestHandlerFactory.requestHandler(pattern, i);
            temp.setNext(nextHandler);
            temp = nextHandler;
        }
    }


    public int findFirstIn(String predicateString) {
        Request r = new Request(predicateString);
        handler.handle(r);
        System.out.println(r);
        return r.first();
    }
}
