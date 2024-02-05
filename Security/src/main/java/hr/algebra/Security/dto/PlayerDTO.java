package hr.algebra.Security.dto;


import hr.algebra.Security.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private String name;

    private String team;

    private int age;

    private float height;

    private float weight;

    private String college;

    private String country;

    private int draftYear;

    public PlayerDTO(Player player) {
        this.name = player.getName();
        this.team = player.getTeam();
        this.age = player.getAge();
        this.height = player.getHeight();
        this.weight = player.getWeight();
        this.college = player.getCollege();
        this.country = player.getCountry();
        this.draftYear = player.getDraftYear();
    }
}
