package com.devsu.movements.repository.movement.impl;

import com.devsu.movements.domain.entity.Movement;

import java.util.Date;
import java.util.List;

public interface IMovementRepositoryFacade {

    Movement createMovement(Movement movement);

    List<Movement> findMovementsBetweenDates(Date startDate, Date finishDate, Long accountId);

}
