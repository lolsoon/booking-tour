package com.example.bookingTour.dto;

import com.example.bookingTour.entity.Group;

public class GroupFormForCreating {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group toEntity() {
		return new Group(name);
	}

}
