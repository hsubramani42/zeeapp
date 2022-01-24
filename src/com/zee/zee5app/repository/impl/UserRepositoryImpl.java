package com.zee.zee5app.repository.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	private Set<Register> registers=new TreeSet<>();
	static private UserRepositoryImpl repo = null;

	private UserRepositoryImpl() {

	}


	public static UserRepositoryImpl getInstance() {

		if (repo == null)
			repo = new UserRepositoryImpl();
		return repo;

	}

	@Override
	public String addUser(Register register) {
		boolean status = registers.add(register);
		return status ? "success" : "failed";
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		for (Register register : registers)
			if (register.getId().equals(id))
				return Optional.of(register);
		Register notFound = null;
		return Optional.of(Optional.ofNullable(notFound).orElseThrow(() -> new IdNotFoundException("Invalid Id")));
	}

	@Override
	public List<Register> getAllUsersList() {
		return new ArrayList<>(registers);
	}

	@Override
	public Register[] getAllUsers() {
		return registers.toArray(new Register[registers.size()]);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		boolean status = registers.remove(this.getUserById(id).get());
		return status ? "success" : "failed";
	}

	@Override
	public String updateUserById(String id, Register register) throws IdNotFoundException {
		boolean status = registers.remove(this.getUserById(id).get());
		if (status)
			status = registers.add(register);
		return status ? "success" : "failed";
	}
}