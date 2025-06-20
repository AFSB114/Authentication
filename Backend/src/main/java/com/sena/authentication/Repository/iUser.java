package com.sena.authentication.Repository;

import com.sena.authentication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface iUser extends JpaRepository<User, Integer> {

    User findUserByName(String name);

    @Query("select u from users u where u.name = :name")
    Optional<User> findByName(String name);

    @Query("select u from users u where u.status = 'ACTIVE'")
    List<User> getActiveUsers();

    @Query("select u from users u where u.status = 'INACTIVE'")
    List<User> getInactiveUsers();

    @Query("select u from users u where u.email = :email and u.password = :password")
    List<User> getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
