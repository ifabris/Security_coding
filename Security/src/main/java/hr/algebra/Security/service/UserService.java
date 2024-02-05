package hr.algebra.Security.service;


import hr.algebra.Security.dto.UserDTO;
import hr.algebra.Security.request.UserLoginRequest;
import hr.algebra.Security.request.UserRequest;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO login(UserLoginRequest userLoginRequest);

    void create(UserRequest userRequest);

    void register(UserRequest userRequest);

    void updateById(Long id, UserRequest userRequest);

    void deleteById(Long id);

    void registerInsecure(UserRequest userRequest);
}
