package com.example.jparelationonetoone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5, max = 30, message = "name should range from 5 to 30")
    @Pattern(regexp = "^[A-Za-z]+", message = "name should be only characters")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;
    @Min(value = 18, message = "minimum age should be 18")
    @Column(columnDefinition = "INT NOT NULL CHECK(age>=18)")
    private Integer age;
    @NotEmpty(message = "major should not be empty")
    @Size(min = 10, max = 40, message = "major should range from 10 to 40")
    @Pattern(regexp = "^[A-Za-z]+", message = "major should only be characters")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;

}
