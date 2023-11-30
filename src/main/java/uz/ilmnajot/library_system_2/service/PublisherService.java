package uz.ilmnajot.library_system_2.service;

import uz.ilmnajot.library_system_2.entity.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> findAll();

    Publisher findById(int id);

    void save(Publisher publisher);

    void deleteById(int id);
}
