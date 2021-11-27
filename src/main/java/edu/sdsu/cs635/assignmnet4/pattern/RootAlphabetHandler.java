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
        String base = request.getBaseString();
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) != charMatch) {
                request.incrementIndex();
            } else {
                request.setCurrentCharIndex(i);
                if (next.handle(request)) {
                    request.setFirstMatchFoundAt(i);
                    return true;
                }
            }
        }
        request.setFirstMatchFoundAt(-1);
        return false;
    }
}
