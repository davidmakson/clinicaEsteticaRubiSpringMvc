package com.david.makson.service;

import java.util.List;

import com.david.makson.model.User;

public interface UserService {

	User findById(Integer id);
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(int id);

	List<User> findAll(int identificador);

	User findByName(String nome);
	
}