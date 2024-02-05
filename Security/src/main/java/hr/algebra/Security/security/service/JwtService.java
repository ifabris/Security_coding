package hr.algebra.Security.security.service;


import hr.algebra.Security.model.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);
}
