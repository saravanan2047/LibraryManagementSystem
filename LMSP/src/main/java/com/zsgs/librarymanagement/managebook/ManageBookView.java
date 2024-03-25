package com.zsgs.librarymanagement.managebook;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.libraryset.LibrarySetupView;
import com.zsgs.librarymanagement.model.Books;
//import com.zsgs.librarymanagement.model.Library;


import java.util.List;
import java.util.Scanner;
public class ManageBookView 
{
		private ManageBookModel manageBookModel;
//		private Library library;
		Scanner scan= new Scanner(System.in);
	
		public ManageBookView() 
		{
			manageBookModel = new ManageBookModel(this);
//			library=new Library();
		}
		//business logic
		public void init()
		{
			
			while(true)
			{
				System.out.println("Select any option to proceed..\n1) ADD Books \n2) Update Books \n3) Display All Books \n4) Search Book  \n0) Exit");
				int choice =scan.nextInt();
				switch(choice)
				{
				case 1: addBooks();
				break;
				case 2: updateBooks();
				break;
				case 3: allBooks();
				break;
				case 4:  searchBooks();
				break;
				case 0: System.out.println("<------------> * Directing to main Page * <----------------->");
					new LibrarySetupView().onSetupComplete();
					break;
				default : System.out.println("\nEnter a valid option\n");
				}
				if(choice==0)
					break;
			}
			
		}
		public void addBooks() 
		{
			
			try {
			
			System.out.println("Enter the Book ID : ");
			Books book=new Books();
			int id=scan.nextInt();
			book.setId(id);
			
			System.out.println("Enter the Book Name : ");
			scan.nextLine();
			String bookName=scan.nextLine();
			book.setName(bookName.toLowerCase());
			
			System.out.println("Enter the Author name : ");
			//scan.nextLine();
			String author=scan.nextLine();
			book.setAuthor(author);
			
			System.out.println("Enter the Edition : ");
			String edition=scan.next();
			book.setEdition(edition);
			
			System.out.println("Enter the Journer : ");
			String journer=scan.next();
			book.setJourner(journer);
			
			System.out.println("Entee the Publisher: ");
			scan.nextLine();
			String publication=scan.nextLine();
			book.setPublication(publication);
			
			System.out.println("Enter the Volume : ");
			int volume=scan.nextInt();
			book.setVolume(volume);
			
			System.out.println("Enter the Available count : ");
			int availCount=scan.nextInt();
			book.setAvailableCount(availCount);
			
			
			manageBookModel.addBooks(book);
			}
			catch (Exception e)
			{
				System.out.println("Enter the details correctly....\n");
			}
		}
		public void showLibraryName()
		{
			System.out.println("Current library name : "+LibraryDatabase.getInstance().getLibrary().getLibraryName());
		}
		public void searchBooks() 
		{
			System.out.println("Enter the Book Name To Search : ");
			scan.nextLine();
			String bookName=scan.nextLine();
			System.out.println(bookName);
			
			List<Books> booklist=manageBookModel.serchBook(bookName);
			
			if(!booklist.isEmpty()) {
				System.out.println("The available book from your search are : ");
//				System.out.println(bookName);
				for(Books book:booklist)
				{
					System.out.println("******************************************************************************************\n");
					//System.out.println("Book ID :-->"+book.getId());
					System.out.println("Book   :-->"+book.getName().toUpperCase()+"\tAuthor :-->"+book.getAuthor().toUpperCase()+"\n");
					//System.out.println("Author :-->"+book.getAuthor().toUpperCase());
					System.out.println("Journer :-->"+book.getJourner()+"\tEdition :-->"+book.getEdition()+"\n");
					//System.out.println("Edition :-->"+book.getEdition());
					System.out.println("Publisher :-->"+book.getPublication()+"\tVolume :--->"+book.getVolume()+"\n");
					System.out.println("Availability :-->"+book.getAvailableCount());
					//System.out.println("Volume :--->"+book.getVolume());
					System.out.println("\n******************************************************************************************\n");
				}
			}
			else System.out.println("Book Not Found Enter correctly and  Search again....\n");
		}
		
		public void updateBooks() 
		{
			
			System.out.println("Enter the book ID to edit:");
			int idEdit=scan.nextInt();
			boolean update=manageBookModel.modifyBook(idEdit);
			if(update)
			{
				System.out.println("Select what you want to Modify. \n");
				
				while(true)
				{
					System.out.println("1) Availability \n2) Volume \n3) Edition \n4) Journer \n5) Publication \n6) Exit");
					int choice=scan.nextInt();
					
					switch(choice)
					{
					case 1:
						System.out.println("Enter the new availability");
						int newAvailability=scan.nextInt();
						manageBookModel.modifyAvailability(idEdit,newAvailability);
						System.out.println("Book Availability modified successfully ");
						break;
					case 2:
						System.out.println("Enter the New Volume : ");
						int newVolume=scan.nextInt();
						manageBookModel.modifyVolume(idEdit,newVolume);
						System.out.println("Book Volume was modified Successfully");
						break;
					case 3:
						System.out.println("Enter the New Book Edition : ");
						String newEdition=scan.next();
						manageBookModel.modifyEdition(idEdit,newEdition);
						System.out.println("Book Edition was modified Successfully");
						break;
					case 4:
						System.out.println("Enter the New Journer : ");
						String newJourner=scan.next();
						manageBookModel.modifyJourner(idEdit,newJourner);
						System.out.println("Book Volume was modified Succesfully");
						break;
					case 5:
						System.out.println("Enter the New Publications : ");
						scan.nextLine();
						String newPublication=scan.nextLine();
						manageBookModel.modifyPublication(idEdit,newPublication);
						System.out.println("Book Publication was modified Successfully");
						break;
						
					case 6: break;
					}
					if(choice==6) break;
					
				}
			}
			else
			{
				System.out.println("\n Enter a valid book ID .\n");
			}
			
			
		}
		public void allBooks() 
		{
			List<Books> bookList1=manageBookModel.allBooks();
			if(bookList1.isEmpty())
				System.out.println("First add books to display it..!!!\n");
			else {
				System.out.println("All the books are : ");
				
				for(Books book:bookList1)
				{
				System.out.println("*******************************************************************************************************************************\n");
				System.out.println("Book Id: "+book.getId()+"\tAuthor :"+book.getAuthor().toUpperCase()+"\tBook--> "+book.getName().toUpperCase()+"\tPublisher--> "+book.getPublication()+"\tAvailability--> "+book.getAvailableCount());	
				System.out.println("\n*********************************************************************************************************************************");
				}
		}
		}
		public void alert(String string) {
			System.out.println(string);
			init();
			
		}	
}
