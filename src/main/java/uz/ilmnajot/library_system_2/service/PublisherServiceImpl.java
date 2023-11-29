package uz.ilmnajot.library_system_2.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.library_system_2.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
}
