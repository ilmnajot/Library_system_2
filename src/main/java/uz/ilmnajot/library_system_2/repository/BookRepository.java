package uz.ilmnajot.library_system_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.library_system_2.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b from Book b where b.bookName like %?1%"
            + "or b.isbn like %?1%"
            + "or b.bookSerialName like %?1%"
            + "or b.booksAuthor like %?1%"
    )
    List<Book> findByName(String keyword);

}
