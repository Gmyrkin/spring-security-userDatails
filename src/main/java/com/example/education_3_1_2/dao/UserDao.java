package com.example.education_3_1_2.dao;

import com.example.education_3_1_2.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void updateUser (User user);
    User getUserId (long id); // поиск по ID
    User getUserByName (String user); // поиск по имени
    List<User> getAllUsers ();
    void deleteUser (User user);

}