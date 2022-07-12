package com.ashleybattles.books.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashleybattles.books.models.Book_Model;
import com.ashleybattles.books.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		System.out.println(bookId);
		Book_Model book = bookService.findBook(bookId);
		System.out.println(book);
		
//		ArrayList<Book_Model> books = bookService.allBooks();
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book_Model> books = bookService.allBooks();
		model.addAttribute("allBooksMatch",books);
		return "index.jsp";
 }
	
	
	

}
