package uz.ilmnajot.library_system_2.service;

import uz.ilmnajot.library_system_2.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int theID);

    void save(Book theBook);

    void deleteById(int theID);

    List<Book> findBookByName(String keyword);
}
