package com.perscholas.java_basics;

public class Main {

    public static void main(String[] args) {

        Employee manager = new Manager(126534, "Peter", "Chennai India", (long)237844, 65000);
        manager.calculateSalary();

        Employee trainee = new Trainee(29846, "Jack", "Mumbai India", (long)442085, 45000);
        trainee.calculateSalary();

        manager.calculateTransportAllowance();
        trainee.calculateTransportAllowance();


    }
}
