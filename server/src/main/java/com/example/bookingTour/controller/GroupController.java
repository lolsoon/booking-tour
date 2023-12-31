package com.example.bookingTour.controller;

import com.example.bookingTour.dto.GroupFormForCreating;
import com.example.bookingTour.dto.GroupFormForUpdating;
import com.example.bookingTour.dto.filter.GroupFilter;
import com.example.bookingTour.entity.Group;
import com.example.bookingTour.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/groups")
public class GroupController {

	@Autowired
	private IGroupService service;

	@GetMapping()
	public ResponseEntity<?> getAllGroups(
			Pageable pageable, 
			GroupFilter filter,
			@RequestParam(required = false) 
			String search) {
		Page<Group> entities = service.getAllGroups(pageable, filter, search);
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> existsGroupByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>(service.isGroupExistsByName(name), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createGroup(@RequestBody GroupFormForCreating form) {
		service.createGroup(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGroupByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<>(service.getGroupByID(id), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroup(@PathVariable(name = "id") short id, @RequestBody GroupFormForUpdating form) {
		service.updateGroup(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{ids}")
	public ResponseEntity<?> deleteGroups(@PathVariable(name = "ids") List<Short> ids) {
		service.deleteGroups(ids);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
