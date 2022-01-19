package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register register = new Register();

		register.setFirstName("Subramani");
		register.setLastName("H");
		register.setEmail("hsubramani42@gmail.com");
		register.setPassword("hsubramani42");

		System.out.println("Register Object: " + register);

		Login login = new Login();

		login.setUserName("hsubramani42@gmail.com");
		login.setPassword("hsubramani42");

		System.out.println("Login Object: " + login);

		UserService userService = UserService.getInstance();
		for(int i=1;i<=10;i++) {
			register = new Register();
			register.setId(""+i);
			register.setFirstName("User");
			register.setLastName(""+i);
			register.setEmail("user"+i+"@gmail.com");
			register.setPassword("pass@user"+i);
			String result = userService.addUser(register);
			
			System.out.println("\nAdded User: "+i+"\nStatus: "+result);
			
		}
		String uid = 10+"";
		
		for(Register user: userService.getUsers()) {
			System.out.println("\nUser Object: "+user);
		}
		
		System.out.println("\nCheck User: "+uid+"\nStatus: "+ (userService.getUserById(uid)!=null));
		
		System.out.println("\nDelete User id: "+uid+"\nStatus: "+ userService.deleteUser(uid));
		
		System.out.println("\nCheck User: "+uid+"\nStatus: "+ (userService.getUserById(uid)!=null));
		
		
		for(int i=11;i<=21;i++) {
			register = new Register();
			register.setId(""+i);
			register.setFirstName("User");
			register.setLastName(""+i);
			register.setEmail("user"+i+"@gmail.com");
			register.setPassword("pass@user"+i);
			String result = userService.addUser(register);
			
			System.out.println("\nAdded User: "+i+"\nStatus: "+result);
			
		}
		int mid=21;
		Register modify = userService.getUserById(mid+"");
		modify.setId(10+"");
		System.out.println("\nModify User: "+uid+"\nStatus: "+ (userService.updateUser(mid+"",modify)));
		
		for(Register user: userService.getUsers()) {
			System.out.println("\nUser Object: "+user);
		}
	}

}