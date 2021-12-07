package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler for "." wildcard
 */
public class DotHandler extends AbstractRequestHandler {

    protected DotHandler() {
        super('.');
    }

    @Override
    public boolean handle(Request request) {
        request.incrementIndex();
        return next.handle(request);
    }
}
