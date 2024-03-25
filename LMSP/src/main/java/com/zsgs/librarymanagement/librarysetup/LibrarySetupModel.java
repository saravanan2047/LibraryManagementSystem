package com.zsgs.librarymanagement.librarysetup;

import com.zsgs.librarymanagement.model.Library;

//Access modifier for this LibrarySetupModel class should be default. 
//So that outside of the package this class cannot be accessed.
class LibrarySetupModel {

	// This variable should be private.
	// so that outside of this class cannot access this variable.
	private LibrarySetupView librarySetupView;

	private Library library = new Library();

	// Access modifier for this LibrarySetupModel constructor should be default.
	// So that outside of the package this constructor cannot be accessed.
	LibrarySetupModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;
		library.setLibraryName("ZSGS Library");
		library.setLibraryId(1);
	}

	public void startSetup() {
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete();
		}
	}
}
