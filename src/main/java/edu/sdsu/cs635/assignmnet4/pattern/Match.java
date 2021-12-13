package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

/**
 * Custom pattern matcher using the chain of responsibility pattern.
 * The constructor builds and sets the request handler chain.
 */
public class Match {
    //chain starts here
    private final Handler<PatternMatchRequest> rootHandler;

    /**
     * @param pattern a string to construct the pattern chain from.
     */
    public Match(String pattern) {
        // start the chain with root handler
        this.rootHandler = this.rootHandler(pattern);
        Handler<PatternMatchRequest> temp = rootHandler;
        // subsequent characters are handled with requestHandlers
        for (int i = 1; i < pattern.length(); i++) {
            Handler<PatternMatchRequest> nextHandler = this.requestHandler(pattern, i);
            temp.setNext(nextHandler);
            temp = nextHandler;
        }
    }

    /**
     * @param predicateString the string to be tested against the pattern.
     * @return index at which the first match occurs
     */
    public int findFirstIn(String predicateString) {
        PatternMatchRequest patternMatchRequest = new PatternMatchRequest(predicateString);
        rootHandler.handle(patternMatchRequest);
        return patternMatchRequest.first();
    }
    /**
     * Factory method to create and return rootHandler for the first character
     */
    private Handler<PatternMatchRequest> rootHandler(String pattern) {
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
    /**
     * Factory method to create and return requestHandler for the remaining characters
     */
    private Handler<PatternMatchRequest> requestHandler(String pattern, int index) {
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
