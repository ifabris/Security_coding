package hr.algebra.Security.security.dto;

public class LoginDTO {

private final String jwtToken;

    public LoginDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
