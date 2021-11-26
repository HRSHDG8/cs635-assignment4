package edu.sdsu.cs635.assignmnet4;

import edu.sdsu.cs635.assignmnet4.handler.Handler;
import edu.sdsu.cs635.assignmnet4.pattern.*;

public class Match {
    private final Handler<Request> handler;

    public Match(String pattern) {
        char first = pattern.charAt(0);
        this.handler = getRootHandler(first);
        Handler<Request> temp = handler;
        for (int i = 1; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            temp.setNext(getHandler(c));
            temp = temp.next();
        }
    }

    private Handler<Request> getRootHandler(char c) {
        if (c == '.') {
            return new DotHandler();
        } else if (c == '*') {
            return new NullHandler();
        } else {
            return new FirstAlphabetHandler(c);
        }
    }

    private Handler<Request> getHandler(char c) {
        if (c == '.') {
            return new DotHandler();
        } else if (c == '*') {
            return new NullHandler();
        } else {
            return new AlphabetHandler(c);
        }
    }

    public int findFirstIn(String predicateString) {
        Request r = new Request(predicateString);
        handler.handle(r);
        System.out.println(r);
        return r.first();
    }
}
