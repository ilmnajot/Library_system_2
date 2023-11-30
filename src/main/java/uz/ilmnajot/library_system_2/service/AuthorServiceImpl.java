package uz.ilmnajot.library_system_2.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.library_system_2.entity.Author;
import uz.ilmnajot.library_system_2.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll()
    {
        return null;
    }
}
