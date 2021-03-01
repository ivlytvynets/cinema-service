package com.dev.theatre.service.impl;

import com.dev.theatre.dao.UserDao;
import com.dev.theatre.exception.DataProcessingException;
import com.dev.theatre.model.User;
import com.dev.theatre.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get user with id: " + id));
    }
}
