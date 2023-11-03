package com.devsu.movements.controller;

import com.devsu.movements.domain.MovementDto;
import com.devsu.movements.domain.request.MovementRequestDto;
import com.devsu.movements.service.movement.IMovementService;
import com.devsu.movements.util.endpoint.MovementEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = MovementEndpoint.BASE_PATH)
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.PATCH,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.OPTIONS
        })
public class MovementController {

    private final IMovementService movementService;

    @Autowired
    public MovementController(IMovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping(MovementEndpoint.MOVEMENTS)
    public ResponseEntity<MovementDto>
    createMovement(@Valid @RequestBody MovementRequestDto movementRequestDto) throws IllegalAccessException {
        MovementDto response = movementService.createMovement(movementRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
