package hr.algebra.Security.service;

import hr.algebra.Security.model.Role;
import hr.algebra.Security.repo.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository){
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<Role> findAll() {
        return userRoleRepository.findAll();
    }

}
