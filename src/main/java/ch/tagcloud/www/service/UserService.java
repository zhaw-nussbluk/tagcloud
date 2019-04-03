package ch.tagcloud.www.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ch.tagcloud.www.model.User;

public interface UserService {
	
	@Transactional
    void save(User user);

	@Transactional
    User findByMail(String mail);
    
    @Transactional
    void update(User user);
    
    @Transactional
    List<User> findAll();
}