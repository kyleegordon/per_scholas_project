package com.perscholas.java_basics;

public class Wrapper<T>{
    private T;
    private int accessCount;

    public Wrapper(T t){
        this.t = t;
    }

    public T getValue(){
        accessCount++;
        return t;
    }

}