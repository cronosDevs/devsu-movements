package com.devsu.movements.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long personId;
    private String identificationNumber;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phone;
}
