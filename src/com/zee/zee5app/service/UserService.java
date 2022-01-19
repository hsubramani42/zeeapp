package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserService {

	private UserRepository userRepository = UserRepository.getInstance();

	private UserService() {

	}

	private static UserService service = null;

	public static UserService getInstance() {

		if (service == null)
			service = new UserService();
		return service;

	}
	
	public String addUser(Register register) {
		return this.userRepository.addUser(register);
	}
	
	
	public Register getUserById(String id) {
		return this.userRepository.getUserById(id);
	}
	
	public Register[] getUsers() {
		return this.userRepository.getUsers();
	}
	
	public String deleteUser(String id) {
		return this.userRepository.deleteUser(id);
	}
	
	public String updateUser(String id, Register register) {
		return this.userRepository.updateUser(id, register);
	}

}
