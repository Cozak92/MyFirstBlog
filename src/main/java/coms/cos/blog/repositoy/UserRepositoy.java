package coms.cos.blog.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

//DAO
//자동으로 Bean 등록
public interface UserRepositoy extends JpaRepository<User, Integer> {

}
