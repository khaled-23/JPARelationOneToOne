package com.example.jparelationonetoone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Address {
    @Id
    private Integer teacher_id;
    @Column(columnDefinition = "VARCHAR(50) NOT NULL ")
    private String street;
    @Column(columnDefinition = "VARCHAR(5) NOT NULL")
    private String buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
