package com.perscholas.java_basics;

public class FireMonster extends Monster{

    public FireMonster(String name) {
        super(name);
    }

    public FireMonster() {
    }

    @Override
    String attack() {
        return "Attack with fire!";
    }
}
