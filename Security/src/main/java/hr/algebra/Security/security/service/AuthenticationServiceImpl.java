package hr.algebra.Security.security.service;


import hr.algebra.Security.model.User;
import hr.algebra.Security.repo.UserRepository;
import hr.algebra.Security.security.dto.LoginDTO;
import hr.algebra.Security.security.request.LoginRequest;
import hr.algebra.Security.utils.PasswordUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<LoginDTO> login(LoginRequest req) {
        Optional<User> user = userRepository.findByUsername(req.getUsername());

        if (user.isEmpty() || !PasswordUtils.matchesPassword(req.getPassword(), user.get().getPassword())) {
            return Optional.empty();
        }

        return Optional.of(
                new LoginDTO(jwtService.createJwt(user.get()))
        );
    }

}
