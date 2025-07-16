package com.aurionpro.authentication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.aurionpro.model.User;
import com.aurionpro.model.UserType;

public class Registration {
	
	public static void register(User user) {
		try {
			File file = new File("Register.dat");
			FileOutputStream fileOutputStream = new FileOutputStream("Register.dat",true);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			if(file.exists() && file.length() > 0) {
				objectOutputStream = new AppendableObjectOutputStream(fileOutputStream);
			}
			else {
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
			}
			
			objectOutputStream.writeObject(user);
			
			System.out.println("Registration successful.");
			
			fileOutputStream.close();
			objectOutputStream.close();	
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}	
	}
}
