package com.devsu.movements.repository.movement;

import com.devsu.movements.domain.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IMovementRepository extends JpaRepository<Movement, Long> {

    @Query("SELECT m FROM Movement m WHERE m.date BETWEEN :startDate AND :endDate AND m.accountId = :accountId")
    List<Movement> findMovementsBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("accountId") Long accountId);

}
