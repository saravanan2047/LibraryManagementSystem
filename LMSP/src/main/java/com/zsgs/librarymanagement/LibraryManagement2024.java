package com.zsgs.librarymanagement;

import com.zsgs.librarymanagement.login.LoginView;

//LibraryManagement2024 Application class. 
//We can maintain application related details here.
public class LibraryManagement2024 
{
	//This variable should be private so that other classes cannot access this variable.
	//Also it should be static so that only one instance will be created.
	private static  LibraryManagement2024 libraryManagement;
	
	private String appName = "Library Management System";
	
	private String appVersion = "0.0.1";

	//default constructor should be private so that we cannot create an instance from other class.
	private LibraryManagement2024() 
	{
		
	}
	//Creating a single instance of this application class.
	//So that we access the application info(appName, appVersion) from any where in the application.
	public static LibraryManagement2024 getInstance() 
	{
		if(libraryManagement == null) 
		{
			libraryManagement = new LibraryManagement2024();
		}
		return libraryManagement;
	}
	private void create() 
	{
		LoginView loginView = new LoginView();
		loginView.start();
	}
	
	public String getAppName() 
	{
		return appName;
	}

	public String getAppVersion() 
	{
		return appVersion;
	}
	//Application execution starts from here.
	public static void main(String arg[]) 
	{	
		//Application created and started from here.
		LibraryManagement2024.getInstance().create();
	}
}

