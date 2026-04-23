package com.rammohan.machine_service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rammohan.machine_service.entity.Machine;
import com.rammohan.machine_service.service.MachineService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/machine")
public class MachineController {

    private final MachineService service;

    public MachineController(MachineService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Machine> create(@RequestBody Machine m) {
        return service.save(m);
    }

    @GetMapping
    public Flux<Machine> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Machine> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}