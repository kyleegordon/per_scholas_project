package com.company.testcourse;

import com.company.Course;
import org.junit.BeforeClass;

public class TestCourse {

    static Course course;

    @BeforeClass
    public static void setUp() {
        course = new Course();
    }

}
