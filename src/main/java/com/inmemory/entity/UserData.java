package com.inmemory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserData {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String roles;
	
}
