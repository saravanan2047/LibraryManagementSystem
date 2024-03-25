package com.zsgs.librarymanagement.login;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Credentials;

class LoginModel 
{
	private LoginView loginView;
	private LibraryDatabase libraryDb;
	private Credentials credential;
//	Credentials credential= new Credentials();
	 public LoginModel(LoginView loginView) 
	{
		this.loginView = loginView;
		credential=LibraryDatabase.getInstance().getCredentials();
	}

	public void validateUser(String userName, String password) 
	{
		if (isValidUserName(userName.trim())) 
		{
			if (isValidPassword(password.trim())) 
			{
				loginView.onSuccess();
			}
			else 
			{
				loginView.showAlert("Invalid password");
				
			}
		} 
		else
		{
			loginView.showAlert("Invalid User Name \n Please re-enter your credentials.");
		}
	}

	// this method should be private because this method used only with in this
	// class.
	private boolean isValidUserName(String userName) 
	{
		//return userName.equals("zsgs");
		return userName.equals(credential.getUserName());
	}

	// this method should be private because this method used only with in this
	// class.
	private boolean isValidPassword(String password) 
	{
		//return password.equals("admin");
		return password.equals(credential.getPassword());
	}

	public void setAdmin(Credentials credential) 
	{
		this.credential=credential;
		libraryDb.getInstance().insertCredentials(credential);
		loginView.init();
	}

	public void loginIs() {
		if(credential==null)
		{
			loginView.setAdminCredentials();
		}
		else
		{
			loginView.init();
		}
			
		
				
	}
}
