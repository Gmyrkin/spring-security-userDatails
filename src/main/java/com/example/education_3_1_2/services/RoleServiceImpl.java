package com.example.education_3_1_2.services;

import com.example.education_3_1_2.dao.RoleDao;
import com.example.education_3_1_2.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);

    }

    @Override
    public Role getRoleId(long id) {
        return roleDao.getRoleId(id);
    }
}
