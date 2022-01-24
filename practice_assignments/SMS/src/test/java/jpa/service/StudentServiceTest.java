package jpa.service;

import jpa.entitymodels.Student;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class StudentServiceTest extends StudentService{

    private static StudentService studentService;

    @BeforeAll
    public static void beforeAll(){
        studentService = new StudentService();
    }

    @Test
    void getStudentByEmailTest() {
        //Given
        Student expected = new Student();
        String actual = "cjaulme9@bing.com";

        //When
        expected = studentService.getStudentByEmail(actual);

        //Then
        Assert.assertEquals(expected.getsEmail(), actual);

    }
}