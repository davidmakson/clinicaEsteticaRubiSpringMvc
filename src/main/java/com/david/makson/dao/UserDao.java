package com.david.makson.dao;

import java.util.List;

import com.david.makson.model.User;

public interface UserDao {

	User findById(Integer id);

	List<User> findAll();

	void save(User user);

	void update(User user);

	void delete(Integer id);

	List<User> findAll(int identificador);

	User findByName(String nome);


}