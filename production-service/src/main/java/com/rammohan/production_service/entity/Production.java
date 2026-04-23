package com.rammohan.production_service.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Table("production")
public class Production {

	@Id
	private Long id;

//	@Column("machine_name")
//	@NotBlank
//	private String machineName;
	
	@Column("machine_id")
	@NotNull
	private Long machineId;

	@Column("units_produced")
	@Min(1)
	private int unitsProduced;

	@Column("shift")
	private String shift;

	@Column("status")
	private String status; // RUNNING, STOPPED

	@Column("created_at")
	private LocalDateTime createdAt;

	public Production() {
	}

	public Production(Long id, /* String machineName, */ Long machineId, int unitsProduced, String shift) {
		this.id = id;
		this.machineId = machineId;
		this.unitsProduced = unitsProduced;
		this.shift = shift;
	}

	public Long getId() {
		return id;
	}

	public Long getMachineId() {
		return machineId;
	}

	public int getUnitsProduced() {
		return unitsProduced;
	}

	public String getShift() {
		return shift;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMachineId(Long machineid) {
		this.machineId = machineid;
	}

	public void setUnitsProduced(int unitsProduced) {
		this.unitsProduced = unitsProduced;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}
}