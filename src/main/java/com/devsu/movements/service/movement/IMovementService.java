package com.devsu.movements.service.movement;

import com.devsu.movements.domain.MovementDto;
import com.devsu.movements.domain.request.MovementRequestDto;

import java.util.List;

public interface IMovementService {
    MovementDto createMovement(MovementRequestDto movementRequestDto);

    List<MovementDto> findMovementsByDates(String initDate, String finishDate, Long accountId);
}
