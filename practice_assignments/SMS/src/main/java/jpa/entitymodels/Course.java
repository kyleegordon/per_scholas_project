package jpa.entitymodels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private int cId;

    @Column(name = "name", nullable = false, length = 50)
    private String cName;

    @Column(name = "instructor", nullable = false, length = 50)
    private String cInstructorName;

    @ManyToMany (mappedBy = "sCourses")
    private List<Student> studentsEnrolled = new ArrayList<>();

    /***Constructors***/
    public Course() {
        this.cId = 0;
        this.cName = "";
        this.cInstructorName = "";
    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    /***Getters/Setters***/
    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    /***Methods***/
    public void addStudent(Student student){
        studentsEnrolled.add(student);
    }
    @Override
    public String toString() {
        return cId +" "+ cName + " " + cInstructorName ;
    }
}
