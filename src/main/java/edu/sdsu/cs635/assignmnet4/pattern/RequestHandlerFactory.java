package edu.sdsu.cs635.assignmnet4.pattern;

import edu.sdsu.cs635.assignmnet4.handler.Handler;

/**
 * Factory class to create and return Handlers for specific use case.
 * rootHandler for the first character
 * requestHandler for the remaining characters
 */
public class RequestHandlerFactory {
    public static Handler<Request> rootHandler(String pattern){
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

    public static Handler<Request> requestHandler(String pattern, int index) {
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
