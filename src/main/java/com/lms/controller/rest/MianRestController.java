package com.lms.controller.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.models.Book;
import com.lms.services.lmsservice;

@RestController
public class MianRestController {

	@Autowired
	private lmsservice lmsServices;
	/*@GetMapping(value="/")
	public String hello()
	{
		return "Hello World";
	}*/
	
	@GetMapping("/findAllBooks")
	public Collection<Book> getAllBooks()
	{
		return lmsServices.findAllBooks();
	}
	
	@GetMapping("/delete")
	public void getdelete(@RequestParam long id)
	{
		lmsServices.delete(id);
	}
	
	
	
}
