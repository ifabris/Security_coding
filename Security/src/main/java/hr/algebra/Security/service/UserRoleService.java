package hr.algebra.Security.service;



import hr.algebra.Security.model.Role;

import java.util.List;

public interface UserRoleService {
    List<Role> findAll();
}
