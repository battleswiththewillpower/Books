package com.ashleybattles.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashleybattles.books.models.Book_Model;
import com.ashleybattles.books.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService; 
	}
	
	@RequestMapping("/api/books")
	public List<Book_Model> index(){
		return bookService.allBooks();
	}
	
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book_Model create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer numOfPages) {
        Book_Model book = new Book_Model(title, description, language, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book_Model show(@PathVariable("id") Long id) {
        Book_Model book = bookService.findBook(id);
        return book;
    }
    
    	// update
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book_Model update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String language,
    		@RequestParam(value="pages") Integer pages) {
        Book_Model book = new Book_Model(title, description, language, pages);
        book.setId(id);
        
        return bookService.updateBook(book);
        
    }
    
//    // destroy
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}
