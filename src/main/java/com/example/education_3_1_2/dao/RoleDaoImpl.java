package com.example.education_3_1_2.dao;

import org.springframework.stereotype.Repository;
import com.example.education_3_1_2.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);

    }

    @Override
    public Role getRoleId(long id) {
        return entityManager.find(Role.class, id);
    }
}
