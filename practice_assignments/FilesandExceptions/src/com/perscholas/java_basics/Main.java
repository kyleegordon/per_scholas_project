package com.perscholas.java_basics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String location = "file.CSV";
        File file = new File(location);
        FileWriter writer = new FileWriter(file, true);
//        writer.write("Course Code, Course Name, Professor\n");
//        writer.write("CIS 335, Advanced Object-Oriented Programming, Bairon Vasquez\n");
//        writer.write("WEB 115, Web Markup and Scripting, D.I. Von Briesen\n");
//        writer.write("DBA 120, Database Programming, Michael Weinberg\n");
        writer.write("CSC 154, Software Development, Meryam Earney\n");

        writer.close();




    }
}
