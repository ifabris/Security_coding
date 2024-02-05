package hr.algebra.Security.security.service;


import hr.algebra.Security.security.dto.LoginDTO;
import hr.algebra.Security.security.request.LoginRequest;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginRequest loginRequest);

}
