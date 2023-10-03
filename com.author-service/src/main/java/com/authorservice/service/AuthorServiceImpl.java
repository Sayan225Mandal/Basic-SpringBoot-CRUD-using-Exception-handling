package com.authorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorservice.exception.AuthorNotFoundException;
import com.authorservice.model.Author;
import com.authorservice.repository.AuthorRepo;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepository;

	@Override
	public Author addAuthor(Author author) {
		Author author1 = authorRepository.save(author);
		return author1;
	}

	@Override
	public List<Author> getAllAuthor() {
		List<Author> authors = authorRepository.findAll();
		return authors;
	}

	@Override
	public Author getAuthorById(int authorid) {
		Author author = authorRepository.findById(authorid)
				.orElseThrow(() -> new AuthorNotFoundException("Author with ID " + authorid + " not found in the database."));
		return author;
	}

	@Override
	public Author updateAuthor(int authorid, Author updatedauthor) {
		Author existingauthor = authorRepository.findById(authorid)
				.orElseThrow(() -> new AuthorNotFoundException("Author with ID " + authorid + " not found in the database."));
		existingauthor.setName(updatedauthor.getName());
		existingauthor.setAge(updatedauthor.getAge());
		existingauthor.setEmail(updatedauthor.getEmail());
		Author newauthor = authorRepository.save(existingauthor);
		return newauthor;
	}

	@Override
	public String deleteAuthor(int authorid) {
		Optional<Author> existauthor = authorRepository.findById(authorid);
		if (existauthor.isPresent()) {
			authorRepository.delete(existauthor.get());
			return "Author ID " + authorid + " is deleted from the database successfully";
		} else {
			throw new AuthorNotFoundException("Author with ID " + authorid + " not found in the database.");
		}
	}

}
