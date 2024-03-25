package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.managebook.ManageBookView;

//Access modifier for this LibrarySetupView class should be public. 
//So that outside of the package this class can be accessed and can create instance for this class.
public class LibrarySetupView {

	// This variable should be private.
	// so that outside of this class cannot access this variable.
	private LibrarySetupModel librarySetupModel;

	// This Constructor should be public.
	// so that all classes can create instance of this class.
	public LibrarySetupView() {
		librarySetupModel = new LibrarySetupModel(this);
	}

	public void init() {
		librarySetupModel.startSetup();
	}

	public void onSetupComplete() {
		System.out.println("\nLibrary setup already completed");
		new ManageBookView().init();
	}

	public void showAlert(String alert) {
		System.out.println("\nPrint any errors here.");
	}

	public void initiateSetup() {
		System.out.println("\n\nGet Library Details From Here.");
	}
}
