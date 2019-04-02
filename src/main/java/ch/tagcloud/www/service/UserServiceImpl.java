package ch.tagcloud.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.tagcloud.www.model.User;
import ch.tagcloud.www.repository.RoleRepository;
import ch.tagcloud.www.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
    
    @Override
    public void update(User user) {

        User userFromDb = userRepository.findByMail(user.getMail());

        userFromDb.setSalutation(user.getSalutation());
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setMail(user.getMail());
        userFromDb.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
        userRepository.save(userFromDb);
    }

    @Override
    public User findByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}