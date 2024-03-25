package com.zsgs.librarymanagement.datalayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zsgs.librarymanagement.login.LoginView;
import com.zsgs.librarymanagement.model.Books;
import com.zsgs.librarymanagement.model.Credentials;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;

public class LibraryDatabase 
{
	private static LibraryDatabase libraryDB;
//	private Credentials credential;
	
	private List<Books>  bookList=new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	private String libraryFile="library.json";
	private String credentialFile="credential.json";
	private String userFile="user.json";
	private String bookFile="book.json";
	
	public static LibraryDatabase getInstance() 
	{
		if (libraryDB == null) 
		{
			libraryDB = new LibraryDatabase();
		}
			return libraryDB;
	}

	public void insertLibrary(Library library) 
	{
//		this.library=library;
		try {
			File file = new File(libraryFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectMapper libraryObj = new ObjectMapper();
			libraryObj.enable(SerializationFeature.INDENT_OUTPUT);
			libraryObj.writeValue(file, library);
		} catch (Exception e) {
			new LoginView().showAlert("Error Occured in adding Company");
		}
	}
	
	public Library getLibrary() 
	{
		ObjectMapper companyObj = new ObjectMapper();
		try {

			return companyObj.readValue(new File(libraryFile), Library.class);
		} catch (Exception e) {
			return null;
		}
	}
	
	public void insertCredentials(Credentials credential)
	{
		ObjectMapper credentialObj = new ObjectMapper();
		try {
			File fileCredential = new File(credentialFile);
			if (!fileCredential.exists()) {
				fileCredential.createNewFile();
			}
			credentialObj.enable(SerializationFeature.INDENT_OUTPUT);
			credentialObj.writeValue(fileCredential, credential);
		} catch (Exception e) {
			new LoginView().showAlert("Error Occured in adding Company");
		}
//		this.credential=credential;
	}
	public Credentials getCredentials()
	{
		ObjectMapper credentialObj = new ObjectMapper();
		try {
			return credentialObj.readValue(new File(credentialFile), Credentials.class);
		} 
		catch (Exception e) {
			return null;
		}
//		return credential;
	}

	public void setPasswords(String newPassword) 
	{
		ObjectMapper credentialObj = new ObjectMapper();
	try {
		Credentials cred=credentialObj.readValue(new File(credentialFile), Credentials.class);
		cred.setPassword(newPassword);
		credentialObj.writeValue(new File(credentialFile), cred);
		
	} 
	catch (Exception e) {
		
	}
	}
	
	public boolean insertBook(Books book)
	{
		ObjectMapper bookObj = new ObjectMapper();
		try {
			File fileBook = new File(bookFile);
			if (!fileBook.exists())
				fileBook.createNewFile();
			if(fileBook.length()>0)
			{
				bookList= bookObj.readValue(new File(bookFile),
						new TypeReference<List<Books>>() {
						});
				for(Books bookId:bookList)
				{
					if(bookId.getId()==book.getId())
					{
						return false;
					}
					else
					{
						bookList.add(book);
						bookObj.writeValue(fileBook, bookList);
						return true;
					}
				}
			}
			else {
				bookList.add(book);
				bookObj.writeValue(fileBook, bookList);
				return true;
			}
		} 
		catch (Exception e){}
		return false;
	}
	// to get details of all the books
	public List<Books> getAllBooks()
	{
		ObjectMapper bookObj = new ObjectMapper();
		try {
			return bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
		} catch (Exception e) {
			return null;
		}
//		return bookList;
	}
	
	// to get details of sepcific book
//	public Books getBook(int bookId)
//	{
//		ObjectMapper bookObj = new ObjectMapper();
//		try {
//			 bookList = bookObj.readValue(new File(bookFile),
//					new TypeReference<List<Books>>() {
//					});
//			 for(Books book:bookList) {
//					if(book.getId()==bookId) 
//					{
//					return book;
//					}
//					} 
//					return null;
//		} catch (Exception e) {
//			return null;
//		}
//		
//	}
	// to search book
	public List<Books> searchBook(String bookName)
	{
		List<Books> searchResult=new ArrayList<>();
		ObjectMapper bookObj = new ObjectMapper();
		try {
			 bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
			 for(Books book:bookList)
				{
					if(book.getName().contains(bookName.toLowerCase()))
					{
						searchResult.add(book);
					}
				}
			 return searchResult;
		} 
		catch (Exception e) {
			return null;
		}
	}
	// checking whether the book is available or not
	public boolean updateBook(int Id)
	{
		for(Books book:bookList)
		{
			if(book.getId()==Id)
			{
				return true;
			}	
		}
		return false;
	}
	// updating the book available count
	public void updateAvailability(int id,int newAvail) 
	{
		ObjectMapper bookObj = new ObjectMapper();
		try {
			 bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
			 for(Books bookAvail:bookList)
				{
					if(bookAvail.getId()==id)
					{
						bookAvail.setAvailableCount(newAvail);
					}	
				}
			 bookObj.writeValue(new File(bookFile), bookList);
		} 
		catch (Exception e) {}
	}

	// updatin the volume of book
	public void updateVolume(int id, int newVolume) {
		ObjectMapper bookObj = new ObjectMapper();
		try {
			 bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
			 for(Books bookAvail:bookList)
				{
					if(bookAvail.getId()==id)
					{
						bookAvail.setVolume(newVolume);
					}	
				}
			 bookObj.writeValue(new File(bookFile), bookList);
		} 
		catch (Exception e) {}	
	}
// updating edition
	public void updateEdition(int id, String newEdition) {
		ObjectMapper bookObj = new ObjectMapper();
		try {
			 bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
			 for(Books bookAvail:bookList)
				{
					if(bookAvail.getId()==id)
					{
						bookAvail.setEdition(newEdition);
					}	
				}
			 bookObj.writeValue(new File(bookFile), bookList);
		} 
		catch (Exception e) {}
	}
	// updating journer
	public void updateJourner(int id, String newJourner) {
		ObjectMapper bookObj = new ObjectMapper();
		try {
			 bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
			 for(Books bookAvail:bookList)
				{
					if(bookAvail.getId()==id)
					{
						bookAvail.setJourner(newJourner);
					}	
				}
			 bookObj.writeValue(new File(bookFile), bookList);
		} 
		catch (Exception e) {}
	}
// updating publication
	public void updatePublication(int id, String newPublication) {
		ObjectMapper bookObj = new ObjectMapper();
		try {
			 bookList = bookObj.readValue(new File(bookFile),
					new TypeReference<List<Books>>() {
					});
			 for(Books bookAvail:bookList)
				{
					if(bookAvail.getId()==id)
					{
						bookAvail.setPublication(newPublication);
					}	
				}
			 bookObj.writeValue(new File(bookFile), bookList);
		} 
		catch (Exception e) {}
	}
	
	// Adding the users by the admin
	public void insertUser(User user) 
	{
		ObjectMapper userObj = new ObjectMapper();
		try {
			File fileUser = new File(userFile);
			if (!fileUser.exists())
				fileUser.createNewFile();
				userList.add(user);
				userObj.writeValue(fileUser, userList);
		} 
		catch (Exception e) {}
	}
	// displaying all the users
	public List<User> getAllUsers()
	{
		ObjectMapper userObj = new ObjectMapper();
		try {
			return userList = userObj.readValue(new File(userFile),
					new TypeReference<List<User>>() {
					});
		} catch (Exception e) {
			return null;
		}
//		return userList;
	}
 //updating user checking condition
	public boolean updateUser(int userId) 
	{
		ObjectMapper userObj = new ObjectMapper();
		try {
			 userList = userObj.readValue(new File(userFile),
					new TypeReference<List<User>>() {
					});
			 for(User user:userList)
				{
					if(user.getId()==userId)
					{
						return true;
					}	
				}
		} 
		catch (Exception e) {
			return false;
		}
		
		return false;
	}

	public void updatePhoneNumbe(int userId, long newPhonenumber) {
		ObjectMapper userObj = new ObjectMapper();
		try {
			 userList = userObj.readValue(new File(userFile),
					new TypeReference<List<User>>() {
					});
			 for(User user:userList)
				{
					if(user.getId()==userId)
					{
						user.setPhoneNo(newPhonenumber);
					}	
				}
			 userObj.writeValue(new File(userFile), userList);
		} 
		catch (Exception e) {
//			return false;
		}
		
		
	}

	public void updateEmail(int userId, String newEmail) {
		ObjectMapper userObj = new ObjectMapper();
		try {
			 userList = userObj.readValue(new File(userFile),
					new TypeReference<List<User>>() {
					});
			 for(User user:userList)
				{
					if(user.getId()==userId)
					{
						user.setEmailId(newEmail);
					}	
				}
			 userObj.writeValue(new File(userFile), userList);
		} 
		catch (Exception e) {
//			return false;
		}
	}

	public void updateAddress(int userId, String newAddress) {
		ObjectMapper userObj = new ObjectMapper();
		try {
			 userList = userObj.readValue(new File(userFile),
					new TypeReference<List<User>>() {
					});
			 for(User user:userList)
				{
					if(user.getId()==userId)
					{
						user.setAddress(newAddress);
					}	
				}
			 userObj.writeValue(new File(userFile), userList);
		} 
		catch (Exception e) {
//			return false;
		}
		for(User user:userList)
		{
			if(user.getId()==userId)
			{
				user.setAddress(newAddress);
			}	
		}
		
	}		
	
}
