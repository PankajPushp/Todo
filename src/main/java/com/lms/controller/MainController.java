package com.lms.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lms.models.Book;
import com.lms.services.lmsservice;

@Controller
public class MainController {

	
	@Autowired
	private lmsservice lmsService;
	@GetMapping("/")
	public String init(HttpServletRequest req)
	{
		req.setAttribute("books",lmsService.findAllBooks());
		req.setAttribute("mode","BOOK_VIEW");
		return "index";
		
	}
	
	@GetMapping("/updateBook")
	public String init(@RequestParam long id, HttpServletRequest req)
	{
		req.setAttribute("book",lmsService.findOne(id));
		req.setAttribute("mode","BOOK_EDIT");
		return "index";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Book book, HttpServletRequest req)
	{
		lmsService.save(book);
		book= null;
		req.setAttribute("books",lmsService.findAllBooks());
		req.setAttribute("mode","BOOK_VIEW");
		
		return "index";
	}
	
	@GetMapping("/newBook")
	public String newBook(HttpServletRequest req)
	{
		req.setAttribute("mode","BOOK_NEW");
		return "index";
	}
	
	@GetMapping("/deleteBook")
	public void deleteBook( @RequestParam long id, HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		lmsService.delete(id);
		//req.setAttribute("books",lmsService.findAllBooks());
		// req.setAttribute("mode","BOOK_VIEW");
		resp.sendRedirect("/");
		//return "index";
	}
	
}
