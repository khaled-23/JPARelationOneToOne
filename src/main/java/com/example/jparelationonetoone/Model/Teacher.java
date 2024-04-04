package com.example.jparelationonetoone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5, max = 30, message = "name should range from 5 to 30")
    @Pattern(regexp = "^[A-Za-z]")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;
    @NotNull(message = "age should not be empty")
    @Min(value = 24, message = "minimum age should be 24")
    @Column(columnDefinition = "INT NOT NULL CHECK(age>=24)")
    private Integer age;
    @Positive(message = "salary should be positive number")
    @Column(columnDefinition = "INT NOT NULL CHECK(salary>0)")
    private Double salary;
    @OneToOne(cascade = CascadeType.REMOVE,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy= "teacher")
    private Set<Course> courses;

}
