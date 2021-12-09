package edu.sdsu.cs635.assignmnet4.handler;

/**
 * This interface is needed since {@link edu.sdsu.cs635.assignmnet4.pattern.NullHandler}
 * can not extend {@link edu.sdsu.cs635.assignmnet4.pattern.AbstractPatternMatchHandler}
 */
public interface Handler<T> {
    void setNext(Handler<T> next);

    boolean handle(T request);
}
