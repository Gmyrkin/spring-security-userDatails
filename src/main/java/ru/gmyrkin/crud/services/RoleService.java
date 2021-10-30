package ru.gmyrkin.crud.services;

import org.springframework.stereotype.Service;
import ru.gmyrkin.crud.model.Role;

public interface RoleService {
    void addRole (Role role);
    Role getRoleId (long id); // поиск по ID
}
