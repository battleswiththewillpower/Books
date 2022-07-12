package com.ashleybattles.books.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashleybattles.books.models.Book_Model;

@Repository
public interface BookRepository extends CrudRepository<Book_Model, Long>{
	 // this method retrieves all the books from the database
    List<Book_Model> findAll();
    // this method finds books with descriptions containing the search string
    List<Book_Model> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);

}
