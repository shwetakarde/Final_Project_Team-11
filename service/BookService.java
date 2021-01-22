package com.Sharecare.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sharecare.model.Book;
import com.Sharecare.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
	
	public Book saveBookDetails(Book book) {
		String tempBookTitle=book.getBookTitle();
		return bookrepository.save(book);
	}

	public List<Book> findAllBooks() {
		return  bookrepository.findAll();
	}
	
//	public Book updateBook(int id, Book book) {
//
//        if (bookrepository.findById(id).isPresent()){
//            Book existingBook = bookrepository.findById(id).get();
//
//            existingBook.setBookTitle(book.getBookTitle());
//            existingBook.setBookAuthor(book.getBookAuthor());
//            existingBook.setBookDescription(book.getBookDescription());
//            existingBook.setNoOfPages(book.getNoOfPages());
//            existingBook.setCategory(book.getCategory());
//
//            Book updatedBook = bookrepository.save(existingBook);
//
////            return new VehicleQueryDTO(updatedVehicle.getId(), updatedVehicle.getVehicleIdentityNumber(),
////                    updatedVehicle.getMake(), updatedVehicle.getModel());0
//            return updatedBook;
//        }else{
//            return null;
//        }
//    }

	public void removeBook(int id) {
		 bookrepository.deleteById(id);
	}

	
	public List<Book> getAllBooksByTitle(String title) {
		return bookrepository.findAllBookByTitle(title);
	}

	public List<Book> getBookByAuthor(String author) {
		return bookrepository.findByBookAuthor(author);
	}
	
	public List<Book> findAllBooksCategoryWise(int categoryId) {
		return bookrepository.findByBookCategory(categoryId);
	}


}
