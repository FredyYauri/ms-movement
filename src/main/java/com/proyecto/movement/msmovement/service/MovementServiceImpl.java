package com.proyecto.movement.msmovement.service;

import com.proyecto.movement.msmovement.repository.MovementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MovementServiceImpl implements MovementService{
    @Autowired
    private MovementRepository movementRepository;
    @Override
    public Flux<com.proyecto.movement.msmovement.entity.Movement> getAll() {
        return movementRepository.findAll();
    }

    @Override
    public Mono<com.proyecto.movement.msmovement.entity.Movement> getMovementByID(Integer idMovement) {
        return movementRepository.findById(idMovement);
    }

    @Override
    public Mono<com.proyecto.movement.msmovement.entity.Movement> saveMovement(com.proyecto.movement.msmovement.entity.Movement account) {
        return movementRepository.save(account);
    }

    @Override
    public Mono<com.proyecto.movement.msmovement.entity.Movement> updateMovement(com.proyecto.movement.msmovement.entity.Movement account) {
        return movementRepository.findById(account.getIdMovement())
                .flatMap(newMovement -> {
                    newMovement.setIdMovement(account.getIdMovement());
                    newMovement.setMovementType(account.getMovementType());
                    newMovement.setIdAccount(account.getIdAccount());
                    newMovement.setMovenmetValue(account.getMovenmetValue());
                    return movementRepository.save(newMovement);
                });
    }

    @Override
    public Mono<com.proyecto.movement.msmovement.entity.Movement> deleteMovement(Integer idMovement) {
        return movementRepository.findById(idMovement)
                .flatMap(account -> movementRepository.delete(account).then(Mono.just(account)));
    }
}
