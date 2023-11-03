package com.devsu.movements.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementRequestDto {
    @NotNull(message = "account can not be null")
    @NotBlank(message = "account can not be empty")
    public String account;
    @NotNull(message = "amount can not be null")
    public Double amount;
}
