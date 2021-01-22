package com.Sharecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Sharecare.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	//@Query(value="select b from book b where b.bookTitle like %keyword%*",nativeQuery = true)
//	List<Book> findByBookTitle(@Param("keyword") String title);

	//jpal
	@Query(value="select b from Book b where b.bookTitle=?1")
	public List<Book> findAllBookByTitle(String title);
	
	@Query(value="select b from Book b where b.bookAuthor=?1")
	public List<Book> findByBookAuthor(String author);

	@Query(value="select b.* from Book b inner join Category c on  b.category=c.categoryId where c.categoryid=?1",nativeQuery = true)
	public List<Book> findByBookCategory(int categoryId);


}
