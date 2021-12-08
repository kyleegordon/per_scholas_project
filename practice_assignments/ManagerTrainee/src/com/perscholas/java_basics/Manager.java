package com.perscholas.java_basics;

public class Manager extends Employee{


    //Constructors

    public Manager(long id, String name, String address, Long phone, double salary) {
        super(id, name, address, phone, salary);

    }

    //Methods


    @Override
    void calculateTransportAllowance() {
        System.out.println(this.getBasicSalary()*.15);
    }
}
