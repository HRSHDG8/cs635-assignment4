package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler for "*" wildcard
 */
public class StarHandler extends AbstractRequestHandler {

    public StarHandler(char charMatch) {
        super(charMatch);
    }

    @Override
    public boolean handle(Request request) {
        if (charMatch == ' ') {
            return true;
        } else {
            for (int i = request.getCurrentCharIndex(); i < request.length(); i++) {
                if (request.isCharAt(charMatch, i)) {
                    // if next character matches the ith value set current char to (i - 1) and invoke next handler
                    request.setCurrentCharIndex(i - 1);
                    if (next.handle(request)) {
                        request.setFirstMatchFoundAt(i);
                        return true;
                    }
                } else {
                    request.incrementIndex();
                }
            }
        }
        return false;
    }
}
