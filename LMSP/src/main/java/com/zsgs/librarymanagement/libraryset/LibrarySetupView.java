package com.zsgs.librarymanagement.libraryset;

import java.util.Scanner;

import com.zsgs.librarymanagement.credential.CredentialView;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.manageUser.ManageUserView;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.model.Library;

public class LibrarySetupView 
{
		//Access modifier for this LibrarySetupView class should be public. 
		//So that outside of the package this class can be accessed and can create instance for this class.
		// This variable should be private.
		// so that outside of this class cannot access this variable.
		private LibrarySetupModel librarySetupModel;
//		private ManageBookView managebookview;
		
		
		// This Constructor should be public.
		// so that all classes can create instance of this class.
		Scanner scan= new Scanner(System.in);
		public LibrarySetupView() 
		{
			librarySetupModel = new LibrarySetupModel(this);
		}
		public void init() 
		{			
			librarySetupModel.startSetup();
		}
		
		public void successRelogin()
		{
			System.out.println("\n******************************************\n");
			new ManageBookView().showLibraryName();
			System.out.println("\n******************************************");
			onSetupComplete();
			
		}
		public void successCreation()
		{
			
			System.out.println("\n******************************************");
			System.out.println("\nLibrary Setup Completed successfully...\n");
			new ManageBookView().showLibraryName();
			System.out.println("\n******************************************");
			onSetupComplete();
			
		}

		public void onSetupComplete() 
		{
			
			// user option
			
			while(true) 
			{
				try {
				System.out.println("\nSelect option for further Step :\n\n1) Manage Users \n2) Manage Book  \n3) Change Password \n4) Log Out  \n5) EXIT ");
				int choice=scan.nextInt();
				switch(choice)
				{
					case 1: new ManageUserView().initUser();
					break;
					case 2: new ManageBookView().init();
					break;
					case 3: new CredentialView().init();
							break;
						
					case 4: System.out.println("\n******* Logged Out Successfully *******\n\n");
							new LoginView().init();
							break;
					case 5:
						System.out.println("~~~~~~~~~~~~ ` Thanks For Using `~~~~~~~~~~~");
						break;
					default : System.out.println("\n Please Enter a Valid Choice\n");
				}
				if(choice==5) System.exit(0);
			}
				catch (Exception e) {
					System.out.println("Enter valid choice");
				}
			}
			// calling next module
			//new ManageBookView().init();
		}
		public void showAlert(String alert) 
		{
			System.out.println(alert);
			initiateSetup();
//			init();
		}
		public void initiateSetup() 
		{
			//System.out.println("\nAdd details first .");
			Library library =new Library();
			System.out.println("Enter the library id: ");
			int libraryId=scan.nextInt();
			library.setLibraryId(libraryId);
			System.out.println("Enter the library Name: ");
			scan.nextLine();
			String libraryName=scan.nextLine();
			library.setLibraryName(libraryName);
			System.out.println("Enter the library Mobile Number: ");
			long libraryMobNum=scan.nextLong();
			library.setPhoneNo(libraryMobNum);
			System.out.println("Enter the library Email: ");
			String libraryemail=scan.next();
			library.setEmailId(libraryemail);
			System.out.println("Enter the library Address: ");
			scan.nextLine();
			String libraryAddress = scan.nextLine();
			// validate firstS
			library.setAddress(libraryAddress);
			
			//librarySetupModel.setupLibrary(libraryId,library);
			librarySetupModel.createLibrary(library);
		}
	}

	


