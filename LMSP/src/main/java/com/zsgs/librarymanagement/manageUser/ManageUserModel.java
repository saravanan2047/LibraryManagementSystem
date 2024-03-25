package com.zsgs.librarymanagement.manageUser;

import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.User;
import com.zsgs.librarymanagement.validate.Validation;

class ManageUserModel {

	private ManageUserView manageUsersView;
	private LibraryDatabase libraryDb;

	ManageUserModel(ManageUserView manageUsersView) {
		libraryDb= LibraryDatabase.getInstance();
		this.manageUsersView = manageUsersView;
	}

	public boolean addNewUser(User user) 
	{
		Validation validEmail=new Validation();//validation
		if(validEmail.validEmail(user.getEmailId()))
		{
			List<User> userList=LibraryDatabase.getInstance().getAllUsers();
			if(userList==null) {
				LibraryDatabase.getInstance().insertUser(user);
				return true;
			}
			else
			{
				for(User userEmail:userList)
				{
					if(user.getEmailId().equals(userEmail.getEmailId()))
					{
						manageUsersView.alert("\nUser already present...!!!\n");
						break;
					}
					else
					{
						LibraryDatabase.getInstance().insertUser(user);
						return true;
						
					}
				}
			}
		}
		return false;
	}
	
	public List<User> getAllUsers() 
	{
		
		return libraryDb.getAllUsers();
	}

	public boolean modifyUser(int userId) 
	{
		boolean stat=libraryDb.updateUser(userId);
		return stat;
	}

	public void modifyPhoneNumber(int userId, long newPhonenumber) {
		
		libraryDb.updatePhoneNumbe(userId,newPhonenumber);
	}

	public void modifyEmail(int userId, String newEmail) {
		libraryDb.updateEmail(userId,newEmail);
		
	}

	public void modifyAddress(int userId, String newAddress) {
		libraryDb.updateAddress(userId,newAddress);
		
	}
}
