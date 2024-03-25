package com.zsgs.librarymanagement.login;

import java.util.Scanner;

import com.zsgs.librarymanagement.LibraryManagement2024;
import com.zsgs.librarymanagement.libraryset.LibrarySetupView;
import com.zsgs.librarymanagement.model.Credentials;

public class LoginView {
	private LoginModel loginModel;
	Scanner scanner = new Scanner(System.in);
	
	public LoginView() {
		loginModel = new LoginModel(this);
	}
	
	public void start() {
		loginModel.loginIs();
		//setAdminCredentials();
		init();
		
	}

	public void init() {
		
		System.out.println("----------- " + LibraryManagement2024.getInstance().getAppName() + " ----------- \n\t\t version: "
				+LibraryManagement2024.getInstance().getAppVersion());
		try {
		while(true)
		{
		System.out.println("\n\n*********** Please login to proceed ************\n1)Admin \n2)User\n");
		int input=scanner.nextInt();
		if(input==1)
			adminLogin();
		else if(input==2)
		{
			
			System.out.println(" !!!!!!!!! User LogIn in under Development !!!!!!!!!!\n\n ~~~~~~~~~~~~~~~~~ Thank You ~~~~~~~~~~~~~~~~~");
			System.out.println("\n\nYou can try to Login With Admin :\n");
			start();
		}
		else {
			System.out.println("Enter a valid option..!!!!");
			break;
		}
		System.exit(input);
		}
		}
		catch (Exception e)
		{
			System.out.println("Enter the right option");
			init();
		}
		
//		System.out.println("\n\n*********** Admin login to proceed ************");
//		System.out.println("\nEnter the user name:");
//		String userName = scanner.nextLine();
//		System.out.println("Enter the password:");
//		String password = scanner.nextLine();
//		//System.out.println(userName+"         "+password); doubt
//		loginModel.validateUser(userName, password);
		
	}
	void setAdminCredentials() {
		
		Credentials credential=new Credentials();
		credential.setPassword("admin");
		credential.setUserName("zsgs");
		loginModel.setAdmin(credential);
		
	}

	public void adminLogin()
	{
		System.out.println("\n\n*********** Admin login to proceed ************");
		System.out.println("\nEnter the user name:");
		String userName = scanner.nextLine();
		System.out.println("Enter the password:");
		String password = scanner.nextLine();
		//System.out.println(userName+"         "+password); doubt
		loginModel.validateUser(userName, password);}

	public void onSuccess() {
		System.out.flush();
		System.out.println(
				"\n\n**************** Login successful *****************\n\n ----- Welcome To " + LibraryManagement2024.getInstance().getAppName()
						+" -----\n  "+ "\n\t\t ----- V" + LibraryManagement2024.getInstance().getAppVersion() + "----\n  ");

		// calling next module
		LibrarySetupView librarySetupView = new LibrarySetupView();
		librarySetupView.init();
	}

	public void showAlert(String alertText) {
		System.out.println(alertText);
		checkForLogin();// calling the input methos again in the login fails
	}
	private void checkForLogin() {
		System.out.println("Do you try again? \nType Yes/No");
	
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			init();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n ---- Thanks You ----");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForLogin();
		}
	}

	
}