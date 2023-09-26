package com.example.bookingTour.repository;

import com.example.bookingTour.entity.User;
import com.example.bookingTour.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	public boolean existsByUserName(String userName);

	public boolean existsByEmail(String email);
	
	@Query("	SELECT 	status 		"
			+ "	FROM 	User 		"
			+ " WHERE 	email = :email")
	public UserStatus findStatusByEmail(@Param("email") String email);

	public User findByUserName(String name);
	
	public User findByEmail(String email);

	User findById(int userId);
}
