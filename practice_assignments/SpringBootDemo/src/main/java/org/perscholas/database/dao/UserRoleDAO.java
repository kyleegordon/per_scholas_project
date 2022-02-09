package org.perscholas.database.dao;


import org.perscholas.database.entity.User;
import org.perscholas.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
}
