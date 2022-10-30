package ru.threexsixth.kata.KATA_PP_3_1_2.service;



import ru.threexsixth.kata.KATA_PP_3_1_2.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
