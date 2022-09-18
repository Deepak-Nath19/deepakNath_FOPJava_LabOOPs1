package com.greatlearning.service;

import com.greatlearning.model.Employee;

public interface CredentialService {

	public String genrateEmailAddress(String firstName , String lastName , String department);
	public char[] generatePassword();
	public void showCredentials(Employee emp , String email, char[] generatedPassword);
	
}
