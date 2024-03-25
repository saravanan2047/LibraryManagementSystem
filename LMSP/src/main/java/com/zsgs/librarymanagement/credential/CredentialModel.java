package com.zsgs.librarymanagement.credential;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;

public class CredentialModel 
{
	private CredentialView credentialView;
	private LibraryDatabase libraryDb;
	
	public CredentialModel(CredentialView credentialView)
	{
		this.credentialView=credentialView;
	}

	public boolean isValid(String passWord) 
	{
		return passWord.equals(libraryDb.getInstance().getCredentials().getPassword());
	}

	public void updatePassword(String newPassword) {
		
		libraryDb.getInstance().setPasswords(newPassword);//getCredentials().setPassword(newPassword);
		credentialView.alert("PassWord updated Successfully....\nKindly Login Again");
	}

}
