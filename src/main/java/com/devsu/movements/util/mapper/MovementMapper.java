package com.devsu.movements.util.mapper;

import com.devsu.movements.domain.MovementDto;
import com.devsu.movements.domain.entity.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovementMapper {
    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    Movement movementDtoToMovement(MovementDto movementDto);

    MovementDto movementToMovementDto(Movement movement);
}
