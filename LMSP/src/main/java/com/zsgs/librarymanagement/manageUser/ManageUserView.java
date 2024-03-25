package com.zsgs.librarymanagement.manageUser;

import java.util.List;
import java.util.Scanner;

import com.zsgs.librarymanagement.libraryset.LibrarySetupView;
import com.zsgs.librarymanagement.model.User;

public class ManageUserView {
	private ManageUserModel manageUserModel;
//	private User user;
	Scanner scan= new Scanner(System.in);
	
	public ManageUserView() {
		manageUserModel = new ManageUserModel(this);
//		user=new User();	
	}
	public void  initUser()
	{
//		
		while(true)
		{
			System.out.println("Select any option to proceed..\n1) ADD user \n2) Update User \n3) Display All User  \n0) Exit");
			int choice =scan.nextInt();
			switch(choice)
			{
			case 1: initAdd();
			break;
			case 2: updateUser();
			break;
			case 3: displayAllUser();
			break;
			case 0: System.out.println("<------------> * Redirecting to Main Page * <----------------->");
				new LibrarySetupView().onSetupComplete();
				break;
			default : System.out.println("\nEnter a valid option\n");
			}
			if(choice==0)
				break;
		}
	}

	public void initAdd() {
		System.out.println("Enter the following User Details: ");
//		Scanner scanner = new Scanner(System.in);
		User user = new User();
		System.out.println("\nEnter User ID: ");
		int id=scan.nextInt();
		user.setId(id);
		System.out.println("\nEnter User name:");
		scan.nextLine();
		user.setName(scan.nextLine());
		System.out.println("\nEnter User EmailId:");
		String email=scan.next();
		user.setEmailId(email);
		System.out.println("\nEnter User Phone Number : ");
		long phNo=scan.nextLong();
		user.setPhoneNo(phNo);
		System.out.println("\nEnter User address : ");
		scan.nextLine();
		String address=scan.nextLine();
		user.setAddress(address);
		if(manageUserModel.addNewUser(user))
		{
			System.out.println("\nUser Added Successfully..\n");
		}
	else 
		{
			System.out.println("Enter a valid email address...!!!");
			initUser();
		}
		
		
	}
	public void alert(String message)
	{
		System.out.println(message);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Library Name ---> " + libraryName);
	}

	public void addUsers(User user) {
		System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
		checkForAddNewUser();
	}

	public void onUserExist(User user) {
		System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
		checkForAddNewUser();
	}

	private void checkForAddNewUser() {
		System.out.println("Do you want to add more users? \nType Yes/No");
//		Scanner scanner = new Scanner(System.in);
		String choice = scan.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n\nThanks for adding users\n");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewUser();
		}
	}

	public void displayAllUser() 
	{
		List<User> allUser=manageUserModel.getAllUsers();
		if(allUser.isEmpty())
		{
			System.out.println("\n First add user to display..!!! \n");
			return ;//librarySetupView.onSetupComplete();
		}
		else
		{
			for(User user:allUser)
			{
				System.out.println("____________________________________________________________________________________________________________________");
				System.out.println(user.getId()+" | "+user.getName()+" | "+user.getEmailId()+" | "+user.getPhoneNo()+" | "+user.getAddress());
				System.out.println("--------------------------------------------------------------------------------------------------------------------");
			}
		}
		
	}
	public void updateUser()
	{

//		Scanner scan=new Scanner(System.in);
		System.out.println("\nEnter the User ID to edit:\n");
		int idEdit=scan.nextInt();
		boolean update=manageUserModel.modifyUser(idEdit);//name ,id,phno, emial, address
		if(update)
		{
			System.out.println("\nSelect what you want to Modify. \n");
			
			while(true)
			{
				System.out.println("1) Phone Number \n2) Email \n3) Address  \n4) Exit");
				int choice=scan.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the new Phone Number: ");
					long newPhonenumber=scan.nextLong();
					manageUserModel.modifyPhoneNumber(idEdit,newPhonenumber);
					System.out.println("User Phone Number modified successfully.");
					break;
				case 2:
					System.out.println("Enter the New Email : ");
					String newEmail=scan.next();
					manageUserModel.modifyEmail(idEdit,newEmail);
					System.out.println("User Email modified Successfully.");
					break;
				case 3:
					System.out.println("Enter the New Address : ");
					scan.nextLine();
					String newAddress=scan.nextLine();
					manageUserModel.modifyAddress(idEdit,newAddress);
					System.out.println("User Address was modified Successfully.");
					break;
				case 4: System.out.println("\n<-----------> Redirecting to User Manage Page <------------->\n");break;
				}
				if(choice==4) break;
				
			}
		}
		else
		{
			System.out.println("\n Enter a valid User ID .\n");
		}
		
		
	}

}
