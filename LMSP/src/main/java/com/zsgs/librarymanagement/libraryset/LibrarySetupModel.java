package com.zsgs.librarymanagement.libraryset;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.validate.Validation;

public class LibrarySetupModel 
{
	//Access modifier for this LibrarySetupModel class should be default. 
	//So that outside of the package this class cannot be accessed.

		// This variable should be private.
		// so that outside of this class cannot access this variable.
		private LibrarySetupView librarySetupView;

		private Library library;// = new Library();

		// Access modifier for this LibrarySetupModel constructor should be default.
		// So that outside of the package this constructor cannot be accessed.
		 LibrarySetupModel(LibrarySetupView librarySetupView) 
		{
			this.librarySetupView = librarySetupView;
			library=LibraryDatabase.getInstance().getLibrary();

		}

		public void startSetup() 
		{
			if (library == null || library.getLibraryId() == 0) 
			{
				librarySetupView.initiateSetup();
			} 
			else	
			{
				librarySetupView. successRelogin();//successCreation();
			}
		}
//		public void setupLibrary(int libraryId)
//		{
//			library= new Library();
//			library.setLibraryId(libraryId);
//			startSetup();
//		}
		public void createLibrary(Library library2)
		{
			Validation validEmail = new Validation();
			boolean stat=validEmail.validEmail(library2.getEmailId()) && validEmail.validPhoneNo(library2.getPhoneNo());
		
			if(stat)
			{
				LibraryDatabase.getInstance().insertLibrary(library2);
				librarySetupView.successCreation();
				//startSetup();
				//value=false;
			}
			else
			{
				librarySetupView.showAlert("Invalid library details \n please re enter proper email and phone Number..\n");
				librarySetupView.initiateSetup();
				
			}
		}
	}


