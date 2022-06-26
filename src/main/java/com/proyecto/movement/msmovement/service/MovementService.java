package com.proyecto.movement.msmovement.service;

import com.proyecto.movement.msmovement.entity.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
    Flux<Movement> getAll();
    Mono<Movement> getMovementByID(Integer idMovement);
    Mono<Movement> saveMovement(Movement account);
    Mono<Movement> updateMovement(Movement account);
    Mono<Movement> deleteMovement(Integer idMovement);


}
