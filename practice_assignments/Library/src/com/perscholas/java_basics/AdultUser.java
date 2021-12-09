package com.perscholas.java_basics;

public class AdultUser implements LibraryUser{
    private int age;
    private String bookType;

    //Constructors

    public AdultUser(int age, String bookType) {
        this.age = age;
        this.bookType = bookType;
    }


    //Methods


    @Override
    public void registerAccount() {
        if (age > 12) {
            System.out.println("You have successfully registered under and Adult Account");
        } else{
            System.out.println("Sorry, Age must be greater than 12 to register as an adult");
        }
    }

    @Override
    public void requestBook() {
        if (bookType.equals("Fiction")){
            System.out.println("Book issued successfully, please return the book within 7 days");
        } else {
            System.out.println("Oops, you are allowed to take only adult Fiction books");
        }
    }
}
