package com.bridgelabz.addressbook;

import java.util.LinkedList;
import java.util.Scanner;

public class AddressbookConsoleService
{
	String firstName, lastName, address, city, state, zip, phoneNumber;
	Scanner scanner = new Scanner(System.in);

	public void createPerson()
	{
		Contacts contact = new Contacts();
		System.out.println("Enter first name :: ");
		contact.setFirstName(scanner.next());
		System.out.println("Enter last name :: ");
		contact.setLastname(scanner.next());
		System.out.println("Enter address :: ");
		contact.setAddress(scanner.next());
		System.out.println("Enter city :: ");
		contact.setCity(scanner.next());
		System.out.println("Enter state :: ");
		contact.setState(scanner.next());
		System.out.println("Enter zip :: ");
		contact.setZip(scanner.next());
		System.out.println("Enter phone number :: ");
		contact.setPhoneNumber(scanner.nextInt());
		System.out.println("Enter Email ::");
		contact.setEmail(scanner.next());
		scanner.close();
		
		System.out.println(contact);
		
	}
}
