package uz.ilmnajot.library_system_2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@Table(name = "BOOK")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "BOOK_NAME")
    String bookName;

    @Column(name = "BOOK_SUBNAME")
    String bookSubName;

    @Column(name = "BOOK_SERIAL_NAME")
    String bookSerialName;

    @Column(name = "BOOKS_AUTHOR")
    String booksAuthor;

    @Column(name = "BOOKS_PUBLISHER")
    String booksPublisher;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "ISBN")
    String isbn;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "AUTHOR_ID")
    Author author;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "PUBLISHER_ID")
    Publisher publisher;

}
