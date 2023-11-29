package uz.ilmnajot.library_system_2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    Integer id;

    @Column(name = "AUTHOR_NAME")
    String authorName;

    @Column(name = "DESCRIPTION")
    String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "author",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    List<Book> bookList = new ArrayList<>();

    public void add(Book tempBook) {
        if (bookList==null){
            bookList = new ArrayList<>();
        }
        bookList.add(tempBook);
        tempBook.setAuthor(this);
    }
}
