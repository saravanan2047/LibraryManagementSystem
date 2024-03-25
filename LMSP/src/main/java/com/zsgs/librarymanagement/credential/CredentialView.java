package com.zsgs.librarymanagement.credential;

import java.util.Scanner;

import com.zsgs.librarymanagement.login.LoginView;

public class CredentialView 
{
	private CredentialModel credentialModel;
	private LoginView loginView;
	Scanner scan=new Scanner(System.in);
	public CredentialView()
	{
		credentialModel=new CredentialModel(this);
		loginView= new LoginView();
	}
	public void init()
	{
		
		System.out.println("Enter the OldPassword : ");
		String passWord=scan.next();
		boolean stat=credentialModel.isValid(passWord);
		if(stat)
			changePassword();
		else
		{
			System.out.println("Enter the Correct Old Password to Create New One..");
			init();
		}
		
	}


	private void changePassword() {
		
		System.out.println("Enter the New Password : ");
		String newPassword=scan.next();
		credentialModel.updatePassword(newPassword);
	}
	public void alert(String string) {
		System.out.println(string);
		loginView.init();
		
		
	}

}
