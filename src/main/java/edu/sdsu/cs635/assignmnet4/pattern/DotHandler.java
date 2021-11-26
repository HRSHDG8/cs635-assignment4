package edu.sdsu.cs635.assignmnet4.pattern;

public class DotHandler extends AbstractRequestHandler {

    public DotHandler() {
        super('.');
    }

    @Override
    public boolean handle(Request request) {
        request.incrementIndex();
        request.incrementIndex();
        return next.handle(request);
    }
}
