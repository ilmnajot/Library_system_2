package uz.ilmnajot.library_system_2.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.library_system_2.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
