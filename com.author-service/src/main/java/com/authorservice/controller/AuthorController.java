package com.authorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorservice.model.Author;
import com.authorservice.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/addauthor")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		Author author1 = authorService.addAuthor(author);
		return ResponseEntity.status(HttpStatus.OK).body(author1);
	}
	
	@GetMapping("/getallauthor")
	public ResponseEntity<List<Author>> getAllAuthor(){
		List<Author> author= authorService.getAllAuthor();
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	
	@GetMapping("/getauthorbyid/{authorid}")
	public ResponseEntity<Author> getAuthorById(@PathVariable int authorid){
		Author author = authorService.getAuthorById(authorid);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	
	@PutMapping("/updateauthorbyid/{authorid}")
	public ResponseEntity<Author> updateAuthor(@PathVariable int authorid, @RequestBody Author updatedauthor){
		Author author = authorService.updateAuthor(authorid,updatedauthor);
		return ResponseEntity.status(HttpStatus.OK).body(author);
	}
	
	@DeleteMapping("/deleteauthorbyid/{authorid}")
	public ResponseEntity<String> deleteAuthor(@PathVariable int authorid){
		String message= authorService.deleteAuthor(authorid);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
}
