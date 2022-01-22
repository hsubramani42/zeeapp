package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;;

public class UserRepositoryImpl implements UserRepository {
	private Set<Register> registers=new LinkedHashSet<>();

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
//		for(int i=0;i<registers.size();i++)
//			if(registers.get(i).getId().equals(id)) {
//				registers.set(i, register);
//				return "Success! Updated.";
//			}
//		return "Failed! No objects found.";
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException  {
		for(Register register:registers)
			if(register.getId().equals(id)) {
				return Optional.of(register);
			}
		Register user = null;
		return Optional.of(Optional.ofNullable(user).orElseThrow(()-> new IdNotFoundException("Id not found")));
	}
	

	@Override
	public ArrayList<Register> getAllUsers() {
//		Collections.sort(registers);
//		return registers;
		return new ArrayList<Register>(registers);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		boolean result = registers.remove(this.getUserById(id).get());
		return result?"Success! deleted!":"Failed! object not found.";
	}

}
