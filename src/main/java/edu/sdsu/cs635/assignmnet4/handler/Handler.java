package edu.sdsu.cs635.assignmnet4.handler;

public interface Handler<T> {
    void setNext(Handler<T> next);
    boolean handle(T request);
}
