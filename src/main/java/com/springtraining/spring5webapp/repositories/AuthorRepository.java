package com.springtraining.spring5webapp.repositories;

import com.springtraining.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
