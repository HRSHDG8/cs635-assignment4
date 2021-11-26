package edu.sdsu.cs635.assignmnet4.pattern;

public class Request {
    private final String baseString;
    private int currentChar;
    private int indexFoundAt;
    private boolean hasMatch;
    private int first;

    public Request(String baseString) {
        this.baseString = baseString;
        this.currentChar = 0;
        this.hasMatch = true;
    }

    public void incrementIndex() {
        currentChar++;
    }


    public String getBaseString() {
        return baseString;
    }

    public boolean hasMore(){
        return currentChar < baseString.length();
    }

    public char getCurrentChar() {
        return baseString.charAt(currentChar);
    }

    public void setNoMatch() {
        this.hasMatch = false;
    }


    public void setFirst(int first) {
        this.first=first;
    }

    @Override
    public String toString() {
        return "Request{" +
                "baseString='" + baseString + '\'' +
                ", currentChar=" + currentChar +
                ", indexFoundAt=" + indexFoundAt +
                ", hasMatch=" + hasMatch +
                ", first=" + first +
                '}';
    }

    public int first() {
        return first;
    }

    public void setCurrentChar(int currentChar) {
        this.currentChar =currentChar;
    }
}
