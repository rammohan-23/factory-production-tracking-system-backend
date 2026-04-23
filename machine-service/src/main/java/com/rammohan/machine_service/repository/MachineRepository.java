package com.rammohan.machine_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.rammohan.machine_service.entity.Machine;

public interface MachineRepository extends ReactiveCrudRepository<Machine, Long> {
}