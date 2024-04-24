package com.nsbm.ebookstore.book_service.service;

import com.nsbm.ebookstore.book_service.model.BookModel;

import java.sql.Date;
import java.util.List;

public interface BookService {
    List<BookModel> getAllBooks();
    BookModel addBook(BookModel bookModel);
    void deleteBook(Long id);
    BookModel updateBook(Long id, String isbn, String bookName, String bookAuthor, String publisher, Date addedOn, int quantity);
}
