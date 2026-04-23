package com.rammohan.production_service.dtio;

import com.rammohan.production_service.dto.MachineDTO;

public class ProductionResponse {

	private Long id;
	private int unitsProduced;
	private String shift;
	private MachineDTO machine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUnitsProduced() {
		return unitsProduced;
	}

	public void setUnitsProduced(int unitsProduced) {
		this.unitsProduced = unitsProduced;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public MachineDTO getMachine() {
		return machine;
	}

	public void setMachine(MachineDTO machine) {
		this.machine = machine;
	}

}