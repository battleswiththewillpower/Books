package com.ashleybattles.books.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashleybattles.books.models.Book_Model;
import com.ashleybattles.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// RETURN ALL BOOKS
	public List<Book_Model> allBooks() {
		return bookRepo.findAll();
	}
	//CREATE
	public Book_Model createBook(Book_Model b) {
		return bookRepo.save(b);
	}
	
	//READ - retrieves a book
	public Book_Model findBook(Long id) {
		Optional<Book_Model> optionalBook = bookRepo.findById(id);
		 if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	}
	
//	Update
	public Book_Model updateBook(Book_Model b) {
		return bookRepo.save(b);
	}
	
	
	
	
//	//Delete
//	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
}
