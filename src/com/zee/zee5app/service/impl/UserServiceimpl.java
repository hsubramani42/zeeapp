package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceimpl implements UserService {

	private UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

	private UserServiceimpl() {

	}

	private static UserServiceimpl service = null;

	public static UserServiceimpl getInstance() {

		if (service == null)
			service = new UserServiceimpl();
		return service;

	}

	@Override
	public String addUser(Register register) {
		return this.userRepository.addUser(register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		return this.userRepository.getUserById(id);
	}

	@Override
	public ArrayList<Register> getAllUsers() {
		return this.userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		return this.userRepository.deleteUserById(id);
	}

	@Override
	public String updateUserById(String id, Register register) {
		return this.userRepository.updateUserById(id, register);
	}

}
