package edu.sdsu.cs635.assignmnet4;

import edu.sdsu.cs635.assignmnet4.handler.Handler;
import edu.sdsu.cs635.assignmnet4.pattern.*;

public class Match {
    private final Handler<Request> handler;

    public Match(String pattern) {
        char first = pattern.charAt(0);
        this.handler = getRootHandler(pattern);
        Handler<Request> temp = handler;
        for (int i = 1; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            temp.setNext(getHandler(pattern, i));
            temp = temp.next();
        }
    }

    private Handler<Request> getRootHandler(String s) {
        char c = s.charAt(0);
        if (c == '.') {
            return new DotHandler();
        } else if (c == '*') {
            if(s.length()>1){
                c = s.charAt(1);
            }else{
                c = ' ';
            }
            return new WildCharHandler(c);
        } else {
            return new FirstAlphabetHandler(c);
        }
    }

    private Handler<Request> getHandler(String pattern, int i) {
        char c = pattern.charAt(i);
        if (c == '.') {
            return new DotHandler();
        } else if (c == '*') {
            if(pattern.length()-1>i){
                c = pattern.charAt(i+1);
            }else{
                c = ' ';
            }
            return new WildCharHandler(c);
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
