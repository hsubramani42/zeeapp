package com.zee.zee5app.repository;

import java.util.Arrays;

import com.zee.zee5app.dto.Register;

public class UserRepository {
	private Register[] registers = new Register[10];
	private static int count = 0;

	private UserRepository() {

	}

	static UserRepository repo = null;

	public static UserRepository getInstance() {

		if (repo == null)
			repo = new UserRepository();
		return repo;

	}

	public String addUser(Register register) {
		if (this.count == registers.length) {

			Register temp[] = new Register[this.registers.length * 2];
			System.arraycopy(registers, 0, temp, 0, this.registers.length);
			this.registers = temp;

		}

		this.registers[this.count++] = register;
		return "success";
	}

	public Register getUserById(String id) {
		for (Register register : registers)
			if ((register!=null) && (register.getId().equals(id)))
				return register;
		return null;
	}
	
	public Register[] getUsers() {
		return Arrays.copyOf(registers, count);
	}
	
	public String updateUser(String id, Register register) {
		for(int i=0;i<count;i++) {
			if(registers[i].getId().equals(id)){
				registers[i] = register;
				return "Update success!";
			}
		}
		return "Update failed! No objects found!";
	}
	public String deleteUser(String id) {
		boolean found=false;
		for(int i=1;i<=this.count;i++) {
			if(registers[i-1]==null)
				break;
			if(registers[i-1].getId().equals(id)) {
				found=true;
			}
			if(found) {
				if(i!=this.count)
					registers[i-1]=registers[i];
			}
		}
		if(found) {
			registers[--this.count] = null;
			return "success";
		}
		return "failed! No objects found";
	}
	
}
