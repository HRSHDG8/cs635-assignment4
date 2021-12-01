package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

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
        this.handler = this.rootHandler(pattern);
        Handler<Request> temp = handler;
        // subsequent characters are handled with requestHandlers
        for (int i = 1; i < pattern.length(); i++) {
            Handler<Request> nextHandler = this.requestHandler(pattern, i);
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

    private Handler<Request> rootHandler(String pattern) {
        char c = pattern.charAt(0);
        if (c == '.') {
            return new RootDotHandler();
        } else if (c == '*') {
            if (pattern.length() > 1) {
                c = pattern.charAt(1);
            } else {
                c = ' ';
            }
            return new StarHandler(c);
        } else {
            return new RootAlphabetHandler(c);
        }
    }

    private Handler<Request> requestHandler(String pattern, int index) {
        char c = pattern.charAt(index);
        if (c == '.') {
            return new DotHandler();
        } else if (c == '*') {
            if (pattern.length() - 1 > index) {
                c = pattern.charAt(index + 1);
            } else {
                c = ' ';
            }
            return new StarHandler(c);
        } else {
            return new AlphabetHandler(c);
        }
    }
}
