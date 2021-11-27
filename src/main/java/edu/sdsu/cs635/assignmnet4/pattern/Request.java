package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Base object being operated on by different objects in the chain.
 * Maintains state of the operations performed in each chain
 */
public class Request {
    private final String baseString;
    private int currentCharIndex;
    private int firstMatchFoundAt;

    public Request(String baseString) {
        this.baseString = baseString;
        this.firstMatchFoundAt = -1;
    }

    public void incrementIndex() {
        currentCharIndex++;
    }

    public void setCurrentCharIndex(int currentCharIndex) {
        this.currentCharIndex = currentCharIndex;
    }

    public int getCurrentCharIndex() {
        return currentCharIndex;
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

    public void setFirstMatchFoundAt(int firstMatchFoundAt) {
        this.firstMatchFoundAt = firstMatchFoundAt;
    }

    public int first() {
        return firstMatchFoundAt;
    }

}
