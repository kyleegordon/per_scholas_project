package com.perscholas.java_basics;

public class KidUser implements LibraryUser{
    private int age;
    private String bookType;
    //Constructors


    public KidUser(int age, String bookType) {
        this.age = age;
        this.bookType = bookType;
    }


    //Methods

    @Override
    public void registerAccount() {
        if (age < 12){
            System.out.println("You have successfully registered under a Kids account");
        } else {
            System.out.println("Sorry, Age must be less that 12 to register as a kid");
        }
    }

    @Override
    public void requestBook() {
       if (bookType.equals("Kids")) {
           System.out.println("Book Issued successfully, please return the book within 10 days");
       } else {
           System.out.println("Oops, you are allowed to take only kids books");
       }
    }
}
