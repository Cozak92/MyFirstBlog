package com.cos.blog.repositoy;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;



//DAO
//자동으로 Bean 등록
public interface UserRepositoy extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	
}

// JPA naming 쿼리
// SELECT * FROM user WHERE username = ? AND passsword = ?
//User findByUsernameAndPassword(String username, String password);

//@Query(value="SELECT * FROM user WHERE username = ? AND passsword = ?"), naetiveQuery = true
//User login(String username, String password)
