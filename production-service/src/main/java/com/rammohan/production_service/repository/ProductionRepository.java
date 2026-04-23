package com.rammohan.production_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.rammohan.production_service.entity.Production;

import reactor.core.publisher.Flux;

public interface ProductionRepository extends ReactiveCrudRepository<Production, Long> {
	Flux<Production> findByMachineId(Long machineId);
}