package com.example.jparelationonetoone.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeacherDTO {
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5, max = 30, message = "name should range from 5 to 30")
    @Pattern(regexp = "^[A-Za-z]")
    private String name;
    @NotNull(message = "age should not be empty")
    @Min(value = 24, message = "minimum age should be 24")
    private Integer age;
    @Positive(message = "salary should be positive number")
    private Double salary;
}
