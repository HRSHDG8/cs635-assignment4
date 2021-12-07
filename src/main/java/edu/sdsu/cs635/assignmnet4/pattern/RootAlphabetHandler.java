package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handles the first alphabet in pattern chain
 */
public class RootAlphabetHandler extends AbstractRequestHandler {

    protected RootAlphabetHandler(char a) {
        super(a);
    }

    @Override
    public boolean handle(Request request) {
        for (int i = 0; i < request.length(); i++) {
            if (request.isCharAt(charMatch, i)) {
                request.setCurrentCharIndex(i);
                if (next.handle(request)) {
                    request.setFirstMatchFoundAt(i);
                    return true;
                }
            } else {
                request.incrementIndex();
            }
        }
        request.setFirstMatchFoundAt(-1);
        return false;
    }
}
