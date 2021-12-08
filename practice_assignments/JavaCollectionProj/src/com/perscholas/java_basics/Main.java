package com.perscholas.java_basics;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        //creates an ArrayList of strings with int key value pair
//        ArrayList<int, String> sList = new ArrayList<>();
//        sList.add(1, "Hello");

        Wrapper<Integer> firstWrapper = new Wrapper<>(25);
        Wrapper<Double> wrapperDouble= new Wrapper<>(52.0);
        Wrapper<Scanner> scannerWrapper = new Wrapper<Scanner>(System.in);

    }
}
