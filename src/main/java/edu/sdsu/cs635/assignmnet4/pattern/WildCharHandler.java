package edu.sdsu.cs635.assignmnet4.pattern;

public class WildCharHandler extends AbstractRequestHandler {

    public WildCharHandler(char a) {
        super(a);
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
                        request.setFirst(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
