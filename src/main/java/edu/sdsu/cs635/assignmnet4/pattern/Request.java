package edu.sdsu.cs635.assignmnet4.pattern;

public class Request {
    private final String baseString;
    private int currentCharIndex;
    private int first;

    public Request(String baseString) {
        this.baseString = baseString;
        this.currentCharIndex = 0;
    }

    public void incrementIndex() {
        currentCharIndex++;
    }

    public String getBaseString() {
        return baseString;
    }

    public boolean hasMore() {
        return currentCharIndex < baseString.length();
    }

    public char getCurrentCharValue() {
        return baseString.charAt(currentCharIndex);
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int first() {
        return first;
    }

    public void setCurrentCharIndex(int currentCharIndex) {
        this.currentCharIndex = currentCharIndex;
    }

    public int getCurrentCharIndex() {
        return currentCharIndex;
    }
}
