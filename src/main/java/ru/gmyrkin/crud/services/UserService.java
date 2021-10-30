package ru.gmyrkin.crud.services;

import ru.gmyrkin.crud.model.User;

import java.util.List;

public interface UserService {
    void addUser (User user); // чтоб изменения сразу отправлялись на страницу
    void updateUser (User user);
    User getUserId (long id);
    List<User> getAllUser ();
    void deleteUser (User user);

}
