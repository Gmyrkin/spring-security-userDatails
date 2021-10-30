package ru.gmyrkin.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gmyrkin.crud.dao.RoleDao;
import ru.gmyrkin.crud.dao.UserDao;
import ru.gmyrkin.crud.model.Role;
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
