package uz.ilmnajot.library_system_2.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.library_system_2.entity.Author;
import uz.ilmnajot.library_system_2.entity.Book;
import uz.ilmnajot.library_system_2.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        Author author = null;
        if (optionalAuthor.isPresent()) {
            author = optionalAuthor.get();
        } else {
            throw new RuntimeException("did not find  author id" + id);
        }
        return author;
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);

    }

    @Override
    public void deleteId(int id) {
        authorRepository.deleteById(id);
    }
    @Override
    public void addBook(Author author, Book book) {
        if( authorRepository.findById(author.getId()).isPresent())
            authorRepository.findById(author.getId()).get().getBookList().add(book);
    }
    @Override
    public Optional<Author> getAuthor(Integer authorId) {
        return authorRepository.findById(authorId);
    }
}
