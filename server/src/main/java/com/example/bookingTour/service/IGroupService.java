package com.example.bookingTour.service;

import com.example.bookingTour.dto.GroupFormForCreating;
import com.example.bookingTour.dto.GroupFormForUpdating;
import com.example.bookingTour.dto.filter.GroupFilter;
import com.example.bookingTour.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {

	Page<Group> getAllGroups(Pageable pageable, GroupFilter filter, String search);

	boolean isGroupExistsByName(String name);

	void createGroup(GroupFormForCreating form);

	Group getGroupByID(short id);

	void updateGroup(short id, GroupFormForUpdating form);

	void deleteGroups(List<Short> ids);

}
