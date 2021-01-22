package com.Sharecare.controller;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.Sharecare.model.Book;
import com.Sharecare.repository.BookRepository;
import com.Sharecare.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@Autowired
	private BookRepository bookrepository;
	
	@PostMapping("/addBook")
	@CrossOrigin(origins = "http://localhost:4200")
	public Book addBook(@RequestBody Book book) throws Exception {
		
		book=bookservice.saveBookDetails(book);
		return book;
	}
	
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookservice.findAllBooks();
		
		if(books.isEmpty()){
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateBook/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
		
		Book books=bookrepository.findById(id)
				.orElseThrow();
        
		books.setBookTitle(book.getBookTitle());
		books.setBookAuthor(books.getBookAuthor());
		books.setBookDescription(books.getBookDescription());
		books.setNoOfPages(book.getNoOfPages());
		books.setCategory(books.getCategory());
		
		Book updatedBook=bookrepository.save(books);
		return ResponseEntity.ok(updatedBook);
		
    }
	
	
	@DeleteMapping(value = "deleteBook/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteBook(@PathVariable int id) {
		bookservice.removeBook(id);
		return "success";
	}
	
	@GetMapping(value = "getBook/{title}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Book> getBookByTitle(@PathVariable String title) {
		return bookservice.getAllBooksByTitle(title);
	}
	
	@GetMapping(value = "getBooks/{author}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Book> getBookByAuthor(@PathVariable String author) {
		return bookservice.getBookByAuthor(author);
	
	}

	@RequestMapping(value="/categorybooklist/{categoryId}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Book>> getAllBooksCAtegoryWise(@PathVariable int categoryId){
		
		List<Book> books = bookservice.findAllBooksCategoryWise(categoryId);
		
		if(books.isEmpty()){
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	
	@GetMapping("/books/{bookId}")
	@CrossOrigin(origins = "http://localhost:4200")

	public ResponseEntity<Book> getBookById(@PathVariable int  bookId) {
		Book book = bookrepository.findById(bookId)
				.orElseThrow();
		return ResponseEntity.ok(book);
	}
	
}
