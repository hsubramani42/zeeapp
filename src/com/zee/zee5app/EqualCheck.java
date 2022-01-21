package com.zee.zee5app;

import com.zee.zee5app.dto.Register;

public class EqualCheck {

	public static void main(String[] args) {
		try {
			Register register = new Register("ab00001", "abhinandan", "chivate", "abhi@gmail.com", "123456789");
			
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			Register register2 = new Register("ab00002", "abhinandan", "chivate", "abhi@gmail.com", "123456789");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			System.out.println("equals method call"+register.equals(register2));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
