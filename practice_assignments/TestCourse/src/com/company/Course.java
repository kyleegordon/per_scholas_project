package com.company;

public class Course {
    private int courseId;
    private String courseName;
    private String courseInstructor;

    public Course(int courseId, String courseName, String courseInstructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;

    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

}
