package edu.sdsu.cs635.assignmnet4.pattern;

public class FirstAlphabetHandler extends AbstractRequestHandler {

    public FirstAlphabetHandler(char a) {
        super(a);
    }

    @Override
    public boolean handle(Request request) {
        String base = request.getBaseString();
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) != charMatch) {
                request.incrementIndex();
            } else {
                request.setCurrentChar(i);
                if (next.handle(request)) {
                    request.setFirst(i);
                    return true;
                }
            }
        }
        request.setFirst(-1);
        return false;
    }
}
