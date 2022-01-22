package com.zee.zee5app.dto;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.InvalidEmailFormatException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
//@EqualsAndHashCode
@ToString
public class Register implements Comparable<Register>{
	public Register(String id, String firstName, String lastName, String email, String password)
			throws InvalidNameException, InvalidIdLengthException, InvalidEmailFormatException,
			InvalidPasswordException {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
	}

	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	public void setId(String id) throws InvalidIdLengthException {
		if (id.length() < 6)
			throw new InvalidIdLengthException("Id length < 6.");

		this.id = id;
	}

	public void setFirstName(String firstName) throws InvalidNameException {
		if ((firstName == null) || (firstName == "") || (firstName.length() < 2))
			throw new InvalidNameException("Invalid First Name!");
		this.firstName = firstName;
	}

	public void setLastName(String lastName) throws InvalidNameException {
		if ((lastName == null) || (lastName == "") || (lastName.length() < 2))
			throw new InvalidNameException("Invalid Last Name!");
		this.lastName = lastName;
	}

	public void setEmail(String email) throws InvalidEmailFormatException {
		if ((email==null)||(!email.contains("@")) || (!email.contains(".") || (email.length() < 5)))
			throw new InvalidEmailFormatException("Invalid Email Format");
		this.email = email;
	}

	public void setPassword(String password) throws InvalidPasswordException {
		if ((password==null)||(password.length() < 8))
			throw new InvalidPasswordException("Invalid Password");
		this.password = password;
	}

	@Override
	public int compareTo(Register o) {
		return this.id.compareTo(o.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}	
	

}
