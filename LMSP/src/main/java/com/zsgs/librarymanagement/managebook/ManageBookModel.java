package com.zsgs.librarymanagement.managebook;

import java.util.List;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Books;


public class ManageBookModel 
{
	private ManageBookView manageBookView;
//	private Books book= new Books();
	private LibraryDatabase libraryDb;
	
	ManageBookModel(ManageBookView manageBookView) 
	{
		this.manageBookView=manageBookView;
		libraryDb=LibraryDatabase.getInstance();//new LibraryDatabase();
//		Library library=LibraryDatabase.getInstance().getLibrary();
		
	}	
	
	public void addBooks(Books book)
	{
		
		boolean stat=libraryDb.insertBook(book);
		if(stat)
		{
			manageBookView.alert("\nBook Added Successfully\n");
		}
		else
		{
			manageBookView.alert("\nBook Already present\n");
		}
	}
	
	public List<Books> serchBook(String bookName)
	{
		return libraryDb.searchBook(bookName);
		
			
		
	}

	public List<Books> allBooks() 
	{
		
		return libraryDb.getAllBooks();  
	}

	public boolean modifyBook(int idEdit) 
	{
		boolean stat=libraryDb.updateBook(idEdit);
		return stat;
	}

	public void modifyAvailability(int id,int newAvail) 
	{
		libraryDb.updateAvailability(id,newAvail);
	}

	public void modifyVolume(int id, int newVolume) 
	{
		libraryDb.updateVolume(id,newVolume);
		
	}

	public void modifyEdition(int id, String newEdition) {
		
		libraryDb.updateEdition(id,newEdition);
	}

	public void modifyJourner(int id, String newJourner) {
		libraryDb.updateJourner(id,newJourner);
		
	}

	public void modifyPublication(int id, String newPublication) {
		libraryDb.updatePublication(id,newPublication);
		
	}
	
}



