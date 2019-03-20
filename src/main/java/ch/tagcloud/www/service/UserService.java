package ch.tagcloud.www.service;

import ch.tagcloud.www.model.User;

public interface UserService {
    void save(User user);

    User findByMail(String mail);
}