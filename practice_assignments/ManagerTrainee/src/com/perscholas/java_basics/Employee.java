package com.perscholas.java_basics;

public class Employee {
    private long employeeId;
    private String employeeName;
    private String employeeAddress;
    private Long employeePhone;
    private double basicSalary;
    private double specialAllowance;
    private double Hra;


//Constructors

    public Employee() {
    }

    public Employee(long id, String name, String address, Long phone) {
        this.employeeId = id;
        this.employeeName = name;
        this.employeeAddress = address;
        this.employeePhone = phone;
        this.specialAllowance = 250.80;
        this.Hra = 1000.50;
    }

    public Employee(long id, String name, String address, Long phone, double salary) {
        this.employeeId = id;
        this.employeeName = name;
        this.employeeAddress = address;
        this.employeePhone = phone;
        this.basicSalary = salary;
        this.specialAllowance = 250.80;
        this.Hra = 1000.50;
    }

    //Getters and Setters

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(double specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    public double getHra() {
        return Hra;
    }

    public void setHra(double hra) {
        Hra = hra;
    }


//Methods

    void calculateSalary(){
        System.out.println(basicSalary + (basicSalary * specialAllowance / 100) + (basicSalary * Hra / 100));
    }

    void calculateTransportAllowance(){
        System.out.println(this.getBasicSalary()*.10);
    }
}
