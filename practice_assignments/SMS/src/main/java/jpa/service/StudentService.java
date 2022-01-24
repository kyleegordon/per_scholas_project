package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import javax.persistence.*;
import java.util.List;

public class StudentService implements StudentDAO {
    static EntityManagerFactory emf;
    static EntityManager em;

    /***Helper Methods***/

    public void startEMF(){
        emf = Persistence.createEntityManagerFactory("JPA Service");
        em = emf.createEntityManager();
    }

    public void endEMF(){
        em.close();
        emf.close();
    }

    /***Service Methods***/

    //returns list of all students that exist in the student table, returns null if no students exist
    @Override
    public List<Student> getAllStudents() {

        try{
            startEMF();
            Query q = em.createQuery("SELECT s FROM Student s");
            List<Student> allStudents = q.getResultList();
            endEMF();
            return allStudents;
        }catch(NullPointerException e){
            System.out.println("There are no students currently enrolled");
            return null;
        }

    }

    //returns single student object from table selected by email, returns null if no student exists
    @Override
    public Student getStudentByEmail(String email) {

        try{
            startEMF();
            Query q = em.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
            q.setParameter("email", email);
            Student student = (Student) q.getSingleResult();
            endEMF();
            return student;
        }catch(NoResultException e){
            System.out.println("There are no students currently enrolled with the email: " + email);
            return null;
        }
    }


    //returns true if student in table exists with given email and password
    @Override
    public boolean validateStudent(String email, String password) {
        Student student = this.getStudentByEmail(email);
        return (student.getsEmail().equals(email)) && (student.getsPass().equals(password));
    }

    //adds course to student's course list if not already enrolled
    @Override
    public void registerStudentToCourse(String email, int courseId) {

            Student student = this.getStudentByEmail(email);
            //create list of currently enrolled courses
            List<Course> currentlyEnrolled = this.getStudentCourses(email);

            //checks if student is already enrolled
            boolean enrolled = false;

            for (Course c: currentlyEnrolled) {
                if(c.getcId() == courseId){
                    enrolled = true;
                    break;
                }
            }

            if(enrolled){
                System.out.println("This student is already enrolled in the course");
            }else {

                try{
                    //find course to add
                    startEMF();
                    Query q = em.createQuery("SELECT c FROM Course c where c.cId = :id");
                    q.setParameter("id", courseId);
                    Course addCourse = (Course) q.getSingleResult();

                    //add course
                    currentlyEnrolled.add(addCourse);
                    student.setsCourses(currentlyEnrolled);
                    em.getTransaction().begin();
                    em.merge(student);
                    em.getTransaction().commit();
                    System.out.println("Successfully enrolled");
                    endEMF();
                }catch(NoResultException e){
                    System.out.println("This course does not exist");
                }

            }
    }

    //returns list of all courses student is currently enrolled in
    @Override
    public List<Course> getStudentCourses(String email) {

        try{
            startEMF();
            Query q = em.createNativeQuery("SELECT c.* FROM Course c JOIN student_course sc on c.id = sc.course_id WHERE sc.student_email = :email", Course.class);
            q.setParameter("email", email);
            List<Course> enrolledCourses = q.getResultList();
            endEMF();
            return enrolledCourses;
        }catch(NoResultException e){
            System.out.println("This student is not enrolled in any courses");
            return null;
        }
    }
}
