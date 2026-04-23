package com.rammohan.machine_service.service;

import org.springframework.stereotype.Service;

import com.rammohan.machine_service.entity.Machine;
import com.rammohan.machine_service.repository.MachineRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MachineService {

    private final MachineRepository repo;

    public MachineService(MachineRepository repo) {
        this.repo = repo;
    }

    public Mono<Machine> save(Machine m) {
        return repo.save(m);
    }

    public Flux<Machine> getAll() {
        return repo.findAll();
    }

    public Mono<Machine> getById(Long id) {
        return repo.findById(id);
    }

    public Mono<Void> delete(Long id) {
        return repo.deleteById(id);
    }
}