package com.example.bookingTour.repository;

import com.example.bookingTour.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Short>, JpaSpecificationExecutor<Group> {

	public Group findByName(String name);

	public boolean existsByName(String name);

	public void deleteByIdIn(List<Short> ids);

}
