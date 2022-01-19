package com.zee.zee5app.repository.impl;

import java.util.Arrays;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;;

public class UserRepositoryImpl implements UserRepository {
	private Register[] registers = new Register[10];
	private static int count = 0;

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
		if (this.count == registers.length) {

			Register temp[] = new Register[this.registers.length * 2];
			System.arraycopy(registers, 0, temp, 0, this.registers.length);
			this.registers = temp;

		}

		this.registers[this.count++] = register;
		return "success";
	}

	@Override
	public Register getUserById(String id) {
		for (Register register : registers)
			if ((register != null) && (register.getId().equals(id)))
				return register;
		return null;
	}

	@Override
	public Register[] getAllUsers() {
		return Arrays.copyOf(registers, count);
	}

	@Override
	public String updateUser(String id, Register register) {
		for (int i = 0; i < count; i++) {
			if (registers[i].getId().equals(id)) {
				registers[i] = register;
				return "Update success!";
			}
		}
		return "Update failed! No objects found!";
	}

	@Override
	public String deleteUserById(String id) {
		boolean found = false;
		for (int i = 1; i <= this.count; i++) {
			if (registers[i - 1] == null)
				break;
			if (registers[i - 1].getId().equals(id)) {
				found = true;
			}
			if (found) {
				if (i != this.count)
					registers[i - 1] = registers[i];
			}
		}
		if (found) {
			registers[--this.count] = null;
			return "success";
		}
		return "failed! No objects found";
	}

}
