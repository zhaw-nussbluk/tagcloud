package ch.tagcloud.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.tagcloud.www.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByMail(String mail);
}