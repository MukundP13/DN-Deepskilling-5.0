package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
	public static void main(String[] args) {
		// Load the Spring Application Context from the XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve the managed BookService bean from the Spring container
		BookService bookService = (BookService) context.getBean("bookService");

		// Execute the method to verify everything is wired up
		bookService.logExecution();
	}
}