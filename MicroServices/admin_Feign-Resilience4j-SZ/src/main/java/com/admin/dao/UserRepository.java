package com.admin.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.admin.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("FROM User u WHERE u.username=?1")
	public User findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query("update User u set u.status=true where u.username = ?1")
	void disableUser(String username);
	
	@Modifying
	@Transactional
	@Query("update User u set u.status=false where u.username = ?1")
	void enableUser(String username);
	
	
	@Modifying
	@Transactional
	@Query("update User u set u.featureStatus=?2 where u.username = ?1")
	void setUserFeatureStatus(String username, int featureId);
	
	
	
	
	
	
}
