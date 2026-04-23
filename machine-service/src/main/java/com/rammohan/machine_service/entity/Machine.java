package com.rammohan.machine_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("machine")
public class Machine {

	@Id
	private Long id;

	@Column("name")
	private String name;

	@Column("status")
	private String status;

	@Column("location")
	private String location;

	public Machine() {
	}

	public Machine(Long id, String name, String status, String location) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}