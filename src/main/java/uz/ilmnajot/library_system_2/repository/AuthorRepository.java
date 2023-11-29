package uz.ilmnajot.library_system_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.library_system_2.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
