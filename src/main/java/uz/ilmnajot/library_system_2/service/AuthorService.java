package uz.ilmnajot.library_system_2.service;

import uz.ilmnajot.library_system_2.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(int id);

    void save(Author author);

    void deleteId(int id);
}
