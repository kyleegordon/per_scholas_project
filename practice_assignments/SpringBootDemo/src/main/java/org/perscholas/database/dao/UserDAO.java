package org.perscholas.database.dao;

import org.perscholas.database.entity.User;
import org.perscholas.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    //^^documentation with query method keywords ^^
    //these just magically work without having to write the code for each method

//    @Query("select u from User u where u.id = :id")
    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    public List<User> findByFirstName(@Param("firstName") String firstName);

    public List<User> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);

    public List<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
//    @Query("select u from User u")
//    public List<User> findAll();

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(Integer userId);
}