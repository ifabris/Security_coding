package hr.algebra.Security.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String team;

    private int age;

    private float height;

    private float weight;

    private String college;

    private String country;

    private int draftYear;

    public Player( String name, String team, int age, float height, float weight, String college, String country, int draftYear) {
        this.name = name;
        this.team = team;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.country = country;
        this.draftYear = draftYear;
    }
}
