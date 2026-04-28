package com.rammohan.production_service.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rammohan.production_service.dtio.ProductionResponse;
import com.rammohan.production_service.dto.MachineDTO;
import com.rammohan.production_service.entity.Production;
import com.rammohan.production_service.repository.ProductionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductionService {

	private final ProductionRepository repo;

	private static final Logger log = LoggerFactory.getLogger(ProductionService.class);

//	public ProductionService(ProductionRepository repo) {
//		this.repo = repo;
//	}

	public Mono<Production> save(Production p) {
		log.info("Saving production: {}", p);
		p.setCreatedAt(LocalDateTime.now());
		return repo.save(p);
	}

	public Flux<Production> getAll() {
		return repo.findAll();
	}

	public Mono<Map<String, Object>> getDashboard() {
		return repo.findAll().collectList().map(list -> {
			int total = list.stream().mapToInt(Production::getUnitsProduced).sum();
			long machines = list.stream().map(Production::getMachineId).distinct().count();

			Map<String, Object> result = new HashMap<>();
			result.put("totalProduction", total);
			result.put("totalMachines", machines);
			result.put("records", list.size());

			return result;
		});
	}

	public Flux<Production> search(Long machineId) {
		return repo.findByMachineId(machineId);
	}

	public Mono<Production> update(Long id, Production newData) {
		return repo.findById(id).flatMap(existing -> {
			existing.setMachineId(newData.getMachineId());
			existing.setUnitsProduced(newData.getUnitsProduced());
			existing.setShift(newData.getShift());
			return repo.save(existing);
		});
	}

	public Mono<Map<String, Integer>> shiftReport() {
		return repo.findAll().collectList().map(list -> list.stream().collect(
				Collectors.groupingBy(Production::getShift, Collectors.summingInt(Production::getUnitsProduced))));
	}

	public Mono<Void> delete(Long id) {
		return repo.deleteById(id);
	}
	
	private final WebClient webClient;

	public ProductionService(ProductionRepository repo, WebClient webClient) {
	    this.repo = repo;
	    this.webClient = webClient;
	}
	
	public Mono<MachineDTO> getMachine(Long machineId) {
	    return webClient.get()
	            .uri("http://localhost:8080/machine/" + machineId)
	            .retrieve()
	            .bodyToMono(MachineDTO.class);
	}
	
	public Flux<ProductionResponse> getAllWithMachine() {
	    return repo.findAll()
	            .flatMap(prod ->
	                getMachine(prod.getMachineId())
	                    .map(machine -> {
	                        ProductionResponse res = new ProductionResponse();
	                        res.setId(prod.getId());
	                        res.setUnitsProduced(prod.getUnitsProduced());
	                        res.setShift(prod.getShift());
	                        res.setMachine(machine);
	                        return res;
	                    })
	            );
	}
}