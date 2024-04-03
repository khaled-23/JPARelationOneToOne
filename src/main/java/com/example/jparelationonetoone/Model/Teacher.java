package com.example.jparelationonetoone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;
    @Column(columnDefinition = "INT NOT NULL CHECK(age>=24)")
    private Integer age;
    @Column(columnDefinition = "INT NOT NULL CHECK(salary>0)")
    private Double salary;
    @OneToOne(cascade = CascadeType.REMOVE,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
