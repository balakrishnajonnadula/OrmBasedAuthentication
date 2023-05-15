package com.inmemory.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmemory.entity.UserData;

@Repository
public interface UserRepo extends JpaRepository<UserData, Integer>{
	
	Optional<UserData> findByUserName(String userName);
}
