package com.greatlearning.test;

import java.util.Scanner;

import com.greatlearning.model.Employee;
import com.greatlearning.service.CredentialServiceIMPL;

public class CredentialServiceTest {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		String firstName="";
		String lastName="";
		
		boolean firstNameValid = false;
		boolean lastNameValid = false;
		
		do {
		System.out.println("Enter your First Name :");
		 firstName = sc.nextLine();
		System.out.println("Enter your last Name :");
		 lastName = sc.nextLine();
		
		if(firstName=="") {
			firstNameValid= false;
			System.out.println("you have not entered your first name");
		}else {
			firstNameValid= true;
		}

		if(lastName.equals("")) {
			lastNameValid= false;
			System.out.println("you have not entered your last name");
		}
		else {
			lastNameValid= true;
		}
		
		}while(firstNameValid == false || lastNameValid == false );
			
		Employee emp1 = new Employee(firstName, lastName);
		CredentialServiceIMPL cs = new CredentialServiceIMPL();
		String generatedEmail;
		char[] generatedPassword;
		int option=0;
		String department ="gen";
		do 
		{	
		System.out.println("please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		if(sc.hasNextInt()) {
		 option = sc.nextInt();
		 
		 switch(option) {
			case 1: department="tech";
					break;
			case 2: department="adm";
					break;
			case 3: department="hr";
					break;
			case 4: department="lg";
					break;
			default:option=-1;
					System.out.println("Enter a valid option");
		 }
		}
		else {
			option =-1;
			sc.nextLine();
			System.out.println("Enter a valid option");
		}
		}while(option == -1);
		
		generatedEmail = cs.genrateEmailAddress(emp1.getFirstName().toLowerCase(),
				emp1.getLastName().toLowerCase(), department);
		
		generatedPassword = cs.generatePassword();
		System.out.println(generatedPassword);
		
		cs.showCredentials(emp1, generatedEmail, generatedPassword);
		
		sc.close();
		
	}

}
