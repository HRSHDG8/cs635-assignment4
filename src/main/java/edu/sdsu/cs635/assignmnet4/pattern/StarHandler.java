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
        if(charMatch == ' '){
            return true;
        }else{
            String base = request.getBaseString();
            for (int i = request.getCurrentCharIndex(); i < base.length(); i++) {
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
        }
        return false;
    }
}
