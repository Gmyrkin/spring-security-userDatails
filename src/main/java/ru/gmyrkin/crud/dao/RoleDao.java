package ru.gmyrkin.crud.dao;

import ru.gmyrkin.crud.model.Role;

public interface RoleDao {
    void addRole (Role role);
    Role getRoleId (long id); // поиск по ID

}
