package com.authorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authorservice.model.Author;
@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
