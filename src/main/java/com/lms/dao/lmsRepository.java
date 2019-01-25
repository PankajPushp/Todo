package com.lms.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.lms.models.Book;

@Repository
public interface lmsRepository extends CrudRepository<Book, Long> {
	//public Book findOne(Long id);
}
