package com.scorsaro.hellowebagain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seeds")
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(length = 500)
    private String description;
    public Long quantityInGramsStocked;


    public Seed(String name, String description, Long quantityInGramsStocked) {
        this.name = name;
        this.description = description;
        this.quantityInGramsStocked = quantityInGramsStocked;
    }
}
