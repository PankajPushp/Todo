package com.lms.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.lmsRepository;
import com.lms.models.Book;

@Service
public class lmsservice {

	@Autowired
	private lmsRepository lmsRepo;
	
	public List<Book> findAllBooks(){
		List<Book> books = new ArrayList<Book>();
		for(Book book: lmsRepo.findAll())
		{
			books.add(book);
		}
		return books;
	}
	
	public void delete(long id)
	{
		lmsRepo.deleteById(id);
	}
	
	public Book findOne(long id)
	{
		System.out.println("id="+id);
		System.out.println("id="+lmsRepo.findById(id).get().getAuthor());
		return lmsRepo.findById(id).get(); 
	}
	
	public void save(Book book)
	{
		lmsRepo.save(book);
	}
	
	
}
