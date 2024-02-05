package hr.algebra.Security.dto;

import hr.algebra.Security.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;

    private String email;

    private Set<String> userRoles;

    public UserDTO(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.userRoles = user.getRoles().stream().map(userRole -> userRole.getRole()).collect(java.util.stream.Collectors.toSet());
    }
}
