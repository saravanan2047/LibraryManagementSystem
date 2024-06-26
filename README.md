---

# Library Management System

## Overview

The **Library Management System** is a Java console application designed to manage basic library operations. This program allows users to manage books, perform book transactions, and view book details. The system is designed to help librarians and users efficiently handle library resources and operations.

## Features

### 1. Book Management
- **Add New Books**: Allows the librarian to add new books to the library's inventory. Details such as book ID, title, author, and quantity are required.
- **Remove Books**: Enables the librarian to remove books from the inventory by specifying the book ID.

### 2. Book Transactions
- **Issue Books**: Users can borrow books from the library. The system tracks the issued books and the user details.
- **Return Books**: Users can return borrowed books. The system updates the inventory and transaction records accordingly.

### 3. Book Inquiry
- **Search Books**: Users can search for books by title, author, or book ID.
- **View Book Details**: Users can view detailed information about a specific book, including its availability.

## Concepts and Techniques Used

### 1. Object-Oriented Programming (OOP)
- **Classes and Objects**: The system uses classes such as `Library`, `Book`, and `Transaction` to model the entities in the library.
- **Encapsulation**: Data fields are encapsulated within classes, and access is provided through public methods.
- **Inheritance**: If applicable, different types of users (e.g., librarian and member) can be handled through inheritance.
- **Polymorphism**: Methods that perform similar operations on different types of data can be overridden in subclasses if needed.

### 2. Data Structures
- **ArrayLists**: Used to maintain dynamic lists of books and transactions.
- **HashMaps**: Used for quick lookup of books by their ID.

### 3. File Handling
- **Reading and Writing**: The system may use file I/O to persist the library's inventory and transaction records.

### 4. Exception Handling
- **Try-Catch Blocks**: Used to handle errors gracefully and ensure the system remains robust and user-friendly.

## How to Run

1. **Compile the Program**: Use the following command to compile the Java program:
    ```bash
    javac LibraryManagement2024.java
    ```

2. **Run the Program**: Use the following command to run the compiled Java program:
    ```bash
    java LibraryManagement2024
    ```

## Usage

1. **Add a Book**: Follow the prompts to enter book details such as ID, title, author, and quantity.
2. **Remove a Book**: Enter the book ID of the book to be removed.
3. **Issue a Book**: Enter the user ID and book ID to issue a book.
4. **Return a Book**: Enter the user ID and book ID to return a book.
5. **Search for a Book**: Enter the title, author, or book ID to search for a book.
6. **View Book Details**: Enter the book ID to view detailed information about the book.

## Code Structure

- **LibraryManagement2024.java**: The main file containing the implementation of the library operations.
  - **Library Class**: Manages the overall library operations including adding, removing, and searching for books.
  - **Book Class**: Represents individual book details and operations.
  - **Transaction Class**: Manages book transactions such as issuing and returning books.
  - **Main Class**: Handles user interaction and menu options.

## Requirements

- **Java Development Kit (JDK)**: Ensure that JDK is installed on your system to compile and run the program.


**LOGIN**

![Login](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/29965382-b77f-4e65-9510-9e0474da6807)

**LOGOUT**

![Logout](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/51528088-af4a-45b5-abd8-39442fbe15ff)

**ADD USER**

![Adduser](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/4d6b2f8b-8907-4d7b-b221-7b1fd5553c5a)

**DISPLAY USER**

![DisplayAllUser](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/da4c3848-2638-48be-a492-c816e0fabd81)

**ADD BOOK**

![AddBooks](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/2b52d45b-70c9-46f0-92e7-4fe6e570098b)

**SEACRH BOOK**

![SearchBooks](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/39db7ef8-3594-42ac-ad80-2a2ec2460850)

**DISPLAY ALL BOOKS**

![DisplayAllBooks](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/77ea4eee-81ef-43e2-b7b0-23c74bee39c0)

**UPDATE BOOK DETAILS**

![UpdateBookCount](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/c7538691-eafa-4862-8949-5c58ded81a67)

**USER DETAILS UPDATE**

![UserUpdate](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/9f0dfcd7-6e48-4d99-9872-e285eed89816)

**EXITING APP**

![ExitingApplication](https://github.com/saravanan2047/LibraryManagementSystem/assets/95707512/df9d49ff-8ca4-4fa5-a9db-be161f661a94)




## Contributions

Contributions are welcome! Feel free to fork the repository, submit pull requests, or open issues to discuss potential changes and improvements.

## License

This project is open-source and available under the MIT License.

---
