package jpa.entitymodels;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String sEmail;

    @Column(name = "name", nullable = false, length = 50)
    private String sName;

    @Column(name = "password", nullable = false, length = 50)
    private String sPass;


    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_email", referencedColumnName = "email", unique = false)},
            inverseJoinColumns = {@JoinColumn(name ="course_id", referencedColumnName = "id", unique = false)}
    )
    private List<Course> sCourses = new ArrayList<Course>();

    /***Constructors***/
    public Student() {
        this.sEmail = "";
        this.sName = "";
        this.sPass = "";
        sCourses = null;
    }

    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    /***Getters/Setters***/
    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sEmail='" + sEmail + '\'' +
                ", sName='" + sName + '\'' +
                ", sPass='" + sPass + '\'' +
                '}';
    }
}
