package com.perscholas.java_basics;

public class StoneMonster extends Monster{

    public StoneMonster(String name) {
        super(name);
    }

    public StoneMonster() {
    }

    @Override
    String attack() {
        return "Attack with stones!";
    }
}
