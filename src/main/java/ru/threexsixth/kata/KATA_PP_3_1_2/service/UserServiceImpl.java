package ru.threexsixth.kata.KATA_PP_3_1_2.service;

import org.springframework.stereotype.Service;
import ru.threexsixth.kata.KATA_PP_3_1_2.dao.UserDao;
import ru.threexsixth.kata.KATA_PP_3_1_2.model.User;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
