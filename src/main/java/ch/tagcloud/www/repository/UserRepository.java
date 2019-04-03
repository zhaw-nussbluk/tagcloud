package ch.tagcloud.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ch.tagcloud.www.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMail(String mail);
    
}