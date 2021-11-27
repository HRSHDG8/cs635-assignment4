package edu.sdsu.cs635.assignmnet4;

import edu.sdsu.cs635.assignmnet4.handler.Handler;
import edu.sdsu.cs635.assignmnet4.pattern.Request;
import edu.sdsu.cs635.assignmnet4.pattern.RequestHandlerFactory;

/**
 * Custom pattern matcher using the chain of responsibility pattern.
 * The constructor builds and sets the request handler chain.
 */
public class Match {
    private final Handler<Request> handler;

    /**
     * @param pattern a string to construct the pattern chain from.
     */
    public Match(String pattern) {
        // start the chain with root handler
        this.handler = RequestHandlerFactory.rootHandler(pattern);
        Handler<Request> temp = handler;
        // subsequent characters are handled with requestHandlers
        for (int i = 1; i < pattern.length(); i++) {
            Handler<Request> nextHandler = RequestHandlerFactory.requestHandler(pattern, i);
            temp.setNext(nextHandler);
            temp = nextHandler;
        }
    }

    /**
     * @param predicateString the string to be tested against the pattern.
     * @return index at which the first match occurs
     */
    public int findFirstIn(String predicateString) {
        Request request = new Request(predicateString);
        handler.handle(request);
        return request.first();
    }
}
