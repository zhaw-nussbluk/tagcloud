package ch.tagcloud.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import ch.tagcloud.www.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMail(String mail);
    /*
    @Modifying
    @Query(value="UPDATE user u SET u.salutation = ?1, u.first_name = ?2, u.last_name = ?3, u.mail = ?4, u.PASSWORD = ?5 WHERE u.mail = ?6")
    void updateUser();
    */
    
}