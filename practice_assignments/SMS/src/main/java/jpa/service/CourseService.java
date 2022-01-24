package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import javax.persistence.*;
import java.util.List;

public class CourseService implements CourseDAO {

    //returns list of all courses
    @Override
    public List<Course> getAllCourses() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA Service");
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT a FROM Course a", Course.class);
            List<Course> allCourses = q.getResultList();
            em.close();
            emf.close();
            return allCourses;
        }catch(NoResultException e){
            System.out.println("There are no classes available");
            return null;
        }
    }
}
