package com.rammohan.production_service.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rammohan.production_service.dtio.ProductionResponse;
import com.rammohan.production_service.entity.Production;
import com.rammohan.production_service.service.ProductionService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/production")
public class ProductionController {

	private final ProductionService service;

	public ProductionController(ProductionService service) {
		this.service = service;
	}

	@PostMapping
	public Mono<Production> create(@Valid @RequestBody Production p) {
		return service.save(p);
	}

	@GetMapping
	public Flux<Production> getAll() {
		return service.getAll();
	}

	@GetMapping("/dashboard")
	public Mono<Map<String, Object>> dashboard() {
		return service.getDashboard();
	}

	@PutMapping("/{id}")
	public Mono<Production> update(@PathVariable Long id, @RequestBody Production p) {
		return service.update(id, p);
	}

	@GetMapping("/shift-report")
	public Mono<Map<String, Integer>> shiftReport() {
		return service.shiftReport();
	}

//	@GetMapping("/search")
//	public Flux<Production> search(@RequestParam String machine) {
//		return service.search(machine);
//	}
	
	@GetMapping("/search")
	public Flux<Production> search(@RequestParam Long machineId) {
		return service.search(machineId);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
	@GetMapping("/full")
	public Flux<ProductionResponse> getFullData() {
	    return service.getAllWithMachine();
	}

}