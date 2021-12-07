package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Handler to match alphabetic characters
 */
public class AlphabetHandler extends AbstractRequestHandler {

    protected AlphabetHandler(char charMatch) {
        super(charMatch);
    }

    @Override
    public boolean handle(Request request) {
        request.incrementIndex();
        if (request.hasMore() && request.getCurrentCharValue() == charMatch) {
            return next.handle(request);
        }else{
            return false;
        }
    }
}
