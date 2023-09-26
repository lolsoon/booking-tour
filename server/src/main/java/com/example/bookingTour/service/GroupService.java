package com.example.bookingTour.service;

import com.example.bookingTour.dto.GroupFormForCreating;
import com.example.bookingTour.dto.GroupFormForUpdating;
import com.example.bookingTour.dto.filter.GroupFilter;
import com.example.bookingTour.entity.Group;
import com.example.bookingTour.repository.GroupRepository;
import com.example.bookingTour.specification.GroupSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private GroupRepository repository;

	public Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search) {

		GroupSpecificationBuilder specification = new GroupSpecificationBuilder(filter, search);

		return repository.findAll(specification.build(), pageable);
	}

	public boolean isGroupExistsByName(String name) {
		return repository.existsByName(name);
	}

	public void createGroup(GroupFormForCreating form) {
		repository.save(form.toEntity());
	}

	public Group getGroupByID(short id) {
		return repository.findById(id).get();
	}

	public void updateGroup(short id, GroupFormForUpdating form) {
		Group entity = repository.findById(id).get();
		entity.setName(form.getName());
		entity.setTotalMember(form.getTotalMember());
		repository.save(entity);
	}

	@Transactional
	public void deleteGroups(List<Short> ids) {
		repository.deleteByIdIn(ids);	
	}

}
