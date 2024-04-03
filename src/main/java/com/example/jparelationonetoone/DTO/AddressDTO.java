package com.example.jparelationonetoone.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "teacher id should not be null")
    private Integer teacher_id;
    @NotEmpty(message = "street name should not be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "street name should contain only characters")
    private String street;
    @NotEmpty(message = "building number should not be empty")
    @Pattern(regexp = "^[0-9]+$", message = "building number should be numbers only")
    private String buildingNumber;
}
