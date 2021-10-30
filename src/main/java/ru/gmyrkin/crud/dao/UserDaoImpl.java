package ru.gmyrkin.crud.dao;

import org.springframework.stereotype.Repository;
import ru.gmyrkin.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {


    @PersistenceContext          // для EntityManage если несколько сессий чтоб все корректно работало (кэш хранился отдельно)
    EntityManager entityManager; // класс работает с базой


    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }
    @Override
    public User getUserId(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager
                .createQuery("FROM User") // HQL запрос чтоб взять всех Юзеров
                .getResultList();            // Создание листа Users
        return users;
    }

    @Override
    public User getUserByName (String name) {
        TypedQuery<User> query = entityManager.createQuery(

                "SELECT u FROM User u WHERE u.name = :name", User.class);

        return query.setParameter("name", name).getSingleResult();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.find(User.class, user.getId()));

    }

}
