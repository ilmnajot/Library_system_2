package uz.ilmnajot.library_system_2.service;

import uz.ilmnajot.library_system_2.entity.Author;
import uz.ilmnajot.library_system_2.entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Author findById(int id);

    void save(Author author);

    void deleteId(int id);

    void addBook(Author author, Book book);

    Optional<Author> getAuthor(Integer id);
}
