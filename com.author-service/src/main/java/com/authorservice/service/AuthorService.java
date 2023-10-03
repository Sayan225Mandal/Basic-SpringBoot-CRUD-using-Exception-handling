package com.authorservice.service;

import java.util.List;

import com.authorservice.model.Author;

public interface AuthorService {

	Author addAuthor(Author author);

	List<Author> getAllAuthor();

	Author getAuthorById(int authorid);

	Author updateAuthor(int authorid, Author updatedauthor);

	String deleteAuthor(int authorid);

}
