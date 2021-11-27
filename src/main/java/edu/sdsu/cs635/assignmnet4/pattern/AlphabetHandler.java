package edu.sdsu.cs635.assignmnet4.pattern;

public class AlphabetHandler extends AbstractRequestHandler {

    public AlphabetHandler(char charMatch) {
        super(charMatch);
    }

    @Override
    public boolean handle(Request request) {
        if (request.hasMore() && request.getCurrentCharValue() == charMatch) {
            request.incrementIndex();
            return next.handle(request);
        }else{
            return false;
        }
    }
}
