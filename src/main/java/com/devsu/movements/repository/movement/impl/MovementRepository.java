package com.devsu.movements.repository.movement.impl;

import com.devsu.movements.domain.entity.Movement;
import com.devsu.movements.repository.movement.IMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MovementRepository implements IMovementRepositoryFacade {

    private final IMovementRepository movementRepository;

    @Autowired
    public MovementRepository(IMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement createMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public List<Movement> findMovementsBetweenDates(Date startDate, Date finishDate, Long accountId) {
        return movementRepository.findMovementsBetweenDates(startDate, finishDate, accountId);
    }
}
