package com.javalesson.generics;

public class Container<Type> {
    private Type object1;

    public Container(Type object1) {
        this.object1 = object1;
    }

    public Type getObject1() {
        return object1;
    }

    public void setObject1(Type object1) {
        this.object1 = object1;
    }
}
