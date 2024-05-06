package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }

    public void removeUser(Long id) {
        this.userDao.removeUser(getUserById(id));
    }

    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.getUserByLogin(login);
        if (user != null && !user.getRoles().isEmpty()) {
            return user;
        } else throw new IllegalArgumentException();
    }
}
