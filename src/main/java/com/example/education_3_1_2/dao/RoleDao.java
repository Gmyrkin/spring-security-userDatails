package com.example.education_3_1_2.dao;

import com.example.education_3_1_2.model.Role;

public interface RoleDao {
    void addRole (Role role);
    Role getRoleId (long id); // поиск по ID

}
