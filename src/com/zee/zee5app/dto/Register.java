package com.zee.zee5app.dto;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Register))
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public int compareTo(Register obj) {
		return this.id.compareTo(obj.id);
	}

}
