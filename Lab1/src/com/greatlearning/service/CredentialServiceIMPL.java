package com.greatlearning.service;

import java.util.Random;

import com.greatlearning.model.Employee;

public class CredentialServiceIMPL implements CredentialService {
	
	static String companyName ="greatlearning" ;
	
@Override
public String genrateEmailAddress(String firstName, String lastName, String department) {
	// TODO Auto-generated method stub
	String email = firstName+lastName+"@"+department+"."+companyName+".com";
	
	return email;
}

@Override
public void showCredentials(Employee emp, String email, char[] generatedPassword) {
	System.out.println("Dear "+emp.getFirstName()+" your generated credentials are as follows");
	System.out.println("Email --> "+email);
	String password = new String(generatedPassword);
	System.out.println("Password --> " + password);
}

@Override
public char[] generatePassword() {
	Random random = new Random();
	int length = 8;
	String numbers ="1234567890";
	String alphabetsLowerCase="abcdefghijklmnopqrstuvwxyz";
	String alphabetsUpperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String specialCharacters ="!#$%^&*()";
	String allCharacters = numbers+alphabetsLowerCase+alphabetsUpperCase+specialCharacters;
			
	char[] password = new char[length];
	
	password[0]= alphabetsLowerCase.charAt(random.nextInt(alphabetsLowerCase.length()));
	password[1]= alphabetsUpperCase.charAt(random.nextInt(alphabetsUpperCase.length()));
	password[2]= numbers.charAt(random.nextInt(numbers.length()));
	password[3]= specialCharacters.charAt(random.nextInt(specialCharacters.length()));

	for(int i=4; i<length ;i++)
	{
		password[i] = allCharacters.charAt(random.nextInt(allCharacters.length()));
	}
	
	return password;
}
}
