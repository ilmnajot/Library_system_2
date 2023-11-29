package uz.ilmnajot.library_system_2.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.library_system_2.entity.Book;
import uz.ilmnajot.library_system_2.exception.NotFoundException;
import uz.ilmnajot.library_system_2.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theID) {
        return bookRepository.findById(theID).orElseThrow(()
                -> new NotFoundException(String.format("not found with the ID %d", theID)));

    }

    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theID) {
        bookRepository.deleteById(theID);
    }

    @Override
    public List<Book> findBookByName(String keyword) {
        return bookRepository.findByName(keyword);
    }
}
