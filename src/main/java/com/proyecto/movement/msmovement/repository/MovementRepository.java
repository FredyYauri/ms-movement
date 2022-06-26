package com.proyecto.movement.msmovement.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends ReactiveMongoRepository<com.proyecto.movement.msmovement.entity.Movement,Integer> {
}
