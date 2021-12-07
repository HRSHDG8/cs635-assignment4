package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler for first "." wildcard
 */
public class RootDotHandler extends AbstractRequestHandler {

    protected RootDotHandler() {
        super('.');
    }

    @Override
    public boolean handle(Request request) {
        for (int i = 0; i < request.length(); i++) {
            if (next.handle(request)) {
                request.setFirstMatchFoundAt(i);
                return true;
            }
        }
        request.setFirstMatchFoundAt(-1);
        return false;
    }
}
