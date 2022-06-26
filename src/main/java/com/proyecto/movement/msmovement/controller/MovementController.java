package com.proyecto.movement.msmovement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(value = "/movement")
public class MovementController {
    @Autowired
    private com.proyecto.movement.msmovement.service.MovementService accountService;

    @GetMapping
    public Flux<com.proyecto.movement.msmovement.entity.Movement> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<com.proyecto.movement.msmovement.entity.Movement> getMovementByID(@PathVariable Integer id) {
        return accountService.getMovementByID(id);
    }

    @PostMapping
    public Mono<com.proyecto.movement.msmovement.entity.Movement> saveMovement(@RequestBody com.proyecto.movement.msmovement.entity.Movement account) {
        return accountService.saveMovement(account);
    }

    @PutMapping
    public Mono<com.proyecto.movement.msmovement.entity.Movement> updateMovement(@RequestBody com.proyecto.movement.msmovement.entity.Movement account) {
        return accountService.updateMovement(account);
    }

    @DeleteMapping("/{id}")
    public Mono<com.proyecto.movement.msmovement.entity.Movement> deleteMovement(@PathVariable Integer id) {
        return accountService.deleteMovement(id);
    }


}
