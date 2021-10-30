package ru.gmyrkin.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gmyrkin.crud.dao.UserDao;
import ru.gmyrkin.crud.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);

    }
    @Override
    @Transactional
    public User getUserId(long id) {

        return userDao.getUserId(id);
    }

    @Override
    @Transactional
    public List<User> getAllUser() {

        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

}
