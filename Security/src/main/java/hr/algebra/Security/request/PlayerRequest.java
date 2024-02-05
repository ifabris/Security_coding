package hr.algebra.Security.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequest implements Serializable {

    @NotBlank(message = "Player name is mandatory")
    private String name;

    @NotBlank(message = "Team name is mandatory")
    private String team;

    @NotNull(message = "Player age is mandatory")
    private int age;

    @NotNull(message = "Player height is mandatory")
    private float height;

    @NotNull(message = "Player weight is mandatory")
    private float weight;

    @NotBlank(message = "College name is mandatory")
    private String college;

    @NotBlank(message = "Country name is mandatory")
    private String country;

    @NotNull(message = "Draft year is mandatory")
    private int draftYear;

}
