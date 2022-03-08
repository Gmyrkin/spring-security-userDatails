package com.example.education_3_1_2.services;

import com.example.education_3_1_2.model.Role;

public interface RoleService {
    void addRole (Role role);
    Role getRoleId (long id); // поиск по ID
}
