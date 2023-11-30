package uz.ilmnajot.library_system_2.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.library_system_2.entity.Publisher;
import uz.ilmnajot.library_system_2.exception.NotFoundException;
import uz.ilmnajot.library_system_2.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(int id) {
        return publisherRepository.findById(id).orElseThrow(()
                ->new NotFoundException(String.format("No such publisher with ID %d", id)));
    }

    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);

    }

    @Override
    public void deleteById(int id) {
        publisherRepository.deleteById(id);
    }
}
