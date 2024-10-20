/*
  Name:Shivam Gawande
  Creation Date:26-09-24
  Register(Password encrypted or hashing) and login
 */
package com.login.repo;

import com.login.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    @Query("SELECT u FROM Employee u WHERE (u.username = :usernameOrEmail OR u.email = :usernameOrEmail) ")
    Optional<Employee> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);
}
