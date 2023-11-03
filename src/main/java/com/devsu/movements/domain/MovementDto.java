package com.devsu.movements.domain;

import com.devsu.movements.domain.enums.MovementTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementDto {
    private Long movementId;
    private Date date;
    private MovementTypeEnum type;
    private Double amount;
    private Long accountId;
}
