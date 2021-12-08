package com.perscholas.java_basics;

public class WaterMonster extends Monster{

    public WaterMonster(String name) {
        super(name);
    }

    public WaterMonster() {
    }

    @Override
    String attack() {
        return "Attack with water!";
    }
}
