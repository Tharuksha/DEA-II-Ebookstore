package com.nsbm.ebookstore.book_service.controller;

import com.nsbm.ebookstore.book_service.model.BookModel;
import com.nsbm.ebookstore.book_service.service.serviceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    //Retrieve all books
    @GetMapping("/getAll")
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    //add book
    @PostMapping("/add")
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
        BookModel addedBook = bookService.addBook(bookModel);
        return ResponseEntity.ok(addedBook);
    }

    //update Book
    @PutMapping("/update/{bookId}")
    public ResponseEntity<BookModel> updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestBody BookModel updateRequest
    ) {
        BookModel updatedBook = bookService.updateBook(
                bookId,
                updateRequest.getIsbn(),
                updateRequest.getBookName(),
                updateRequest.getBookAuthor(),
                updateRequest.getPublisher(),
                updateRequest.getAddedOn(),
                updateRequest.getQuantity()
        );
        return ResponseEntity.ok(updatedBook);
    }

    //delete book
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Deleted book successfully");
    }
}
