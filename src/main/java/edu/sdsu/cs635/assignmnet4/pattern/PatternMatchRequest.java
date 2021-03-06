package edu.sdsu.cs635.assignmnet4.pattern;

/**
 * Base object being operated on by different objects in the chain.
 * Maintains state of the operations performed in each chain
 */
public class PatternMatchRequest {
    private final String baseString;
    private int currentCharIndex;
    private int firstMatchFoundAt;

    public PatternMatchRequest(String baseString) {
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

    public boolean isCharAt(char charMatch, int index) {
        return baseString.charAt(index) == charMatch;
    }

    public int length() {
        return baseString.length();
    }

    public boolean isCurrentMatch(char charMatch) {
        return this.hasMore() && baseString.charAt(currentCharIndex) == charMatch;
    }

    public void setFirstMatchFoundAt(int firstMatchFoundAt) {
        this.firstMatchFoundAt = firstMatchFoundAt;
    }

    public int first() {
        return firstMatchFoundAt;
    }

    private boolean hasMore() {
        return currentCharIndex < baseString.length();
    }
}
