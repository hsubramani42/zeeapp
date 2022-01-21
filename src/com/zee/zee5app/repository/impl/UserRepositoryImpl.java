package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;;

public class UserRepositoryImpl implements UserRepository {
	private ArrayList<Register> registers=new ArrayList<>();

	private UserRepositoryImpl() {

	}

	static UserRepositoryImpl repo = null;

	public static UserRepositoryImpl getInstance() {

		if (repo == null)
			repo = new UserRepositoryImpl();
		return repo;

	}

	@Override
	public String addUser(Register register) {
		return (registers.add(register))?"Success! Object added":"Failed! Object not added.";
	}

	@Override
	public String updateUserById(String id, Register register) {
		for(int i=0;i<registers.size();i++)
			if(registers.get(i).getId().equals(id)) {
				registers.set(i, register);
				return "Success! Updated.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public Optional<Register> getUserById(String id) {
		for(Register register:registers)
			if(register.getId().equals(id))
				return Optional.of(register);
		return Optional.empty();
	}

	@Override
	public ArrayList<Register> getAllUsers() {
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		for(int i=0;i<registers.size();i++)
			if(registers.get(i).getId().equals(id)) {
				registers.remove(i);
				return "Success! Deleted.";
			}
		return "Failed! No objects found.";
	}

}
