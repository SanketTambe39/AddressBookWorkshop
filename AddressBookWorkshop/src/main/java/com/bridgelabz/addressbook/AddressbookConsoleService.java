package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgelabz.addressbook.CustomException.ExceptionsType;

public class AddressbookConsoleService
{
	HashMap<String,LinkedList<Contacts>> addressBooks = new HashMap<>();
	Scanner scanner = new Scanner(System.in);

	public Contacts createContact() throws CustomException
	{
		Contacts contact = new Contacts();
		return getDetails(contact);
	}

	private Contacts getDetails(Contacts contact) throws CustomException
	{
		try
		{
			System.out.println("Enter First Name ::");
			contact.setFirstName(scanner.next());
			System.out.println("Enter last Name ::");
			contact.setLastname(scanner.next());
			System.out.println("Enter address ::");
			contact.setAddress(scanner.next());
			System.out.println("Enter City ::");
			contact.setCity(scanner.next());
			System.out.println("Enter State ::");
			contact.setState(scanner.next());
			System.out.println("Enter Pincode ::");
			contact.setZip(scanner.next());
			System.out.println("Enter Phone Number ::");
			contact.setPhoneNumber(scanner.nextInt());
			System.out.println("Enter Email ::");
			contact.setEmail(scanner.next());
			return contact;
		} catch (InputMismatchException e)
		{
			throw new CustomException(ExceptionsType.WRONG_INPUT, "Entered the wrong value");
		}
	}

	public HashMap<String, LinkedList<Contacts>> addContacts(Contacts contact) throws CustomException
	{
		try
		{
			System.out.println("Enter Book name to which you have to add contact");
			String bookName  = scanner.next();

			if (addressBooks.containsKey(bookName))
			{
				LinkedList<Contacts> contactList  =  addressBooks.get(bookName);
				contactList.add(contact);				
				addressBooks.put(bookName, contactList);
				System.out.println("New Contact Added Sucessfully");
			}
			else
			{	
				LinkedList<Contacts> allContacts = new LinkedList<>();
				allContacts.add(contact);
				addressBooks.put(bookName,allContacts);
				System.out.println("New book created and Contact Added Sucessfully");
			}			
		} catch (Exception e)
		{
			throw new CustomException(ExceptionsType.NUll_VALUE, "Obtained value is null");
		}
		return addressBooks;
	}

	public HashMap<String, LinkedList<Contacts>> editContact(String name,String bookName) throws CustomException
	{
		boolean is_found = false;
		if (addressBooks.size()== 0)
		{
			throw new CustomException(ExceptionsType.EMPTY_BOOK, "AddessBook is empty");
		} else
		{

			for (Contacts contact : addressBooks.get(bookName))
			{	
				if (contact.getFirstName().equals(name))
				{
					getDetails(contact);
					is_found = true;
					System.out.println("Contact Updated");
					return addressBooks;
				}
			}
		}
		if (!is_found)
			contactNotPresent(is_found);
		return addressBooks;
	}
	
	public HashMap<String, LinkedList<Contacts>> deleteContact(String name ,String bookName)
	{
		boolean is_found = false;
		LinkedList<Contacts> conatctList = addressBooks.get(bookName);
		for (Contacts contact : conatctList)
		{	
			if (contact.getFirstName().equals(name))
			{
				conatctList.remove(contact);
				System.out.println("Deleted sucessfully");
				return addressBooks;
			}
		}
		contactNotPresent(is_found);
		return addressBooks;
	}

	public void displayContacts()
	{
		for (String bookName : addressBooks.keySet())
		{
			System.out.println(bookName);
			LinkedList<Contacts> contactList  =  addressBooks.get(bookName);
			displayContacts(contactList);
		}
	}
	
	public void displayContacts(LinkedList<Contacts> contactList)
	{
		for (Contacts contact : contactList)
		{	
			System.out.println(contact);
		}
	}
	
	private void contactNotPresent(boolean is_found) 
	{
		if (!is_found)
		{
			System.out.println("Contact not found");
		}
	}
}
