package com.springbootweb.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootweb.webapp.model.User;


public interface UserDAO extends JpaRepository<User, Long>{

	User findByUsernameAndPasswordAndRole(String username, String password, String role);

}
