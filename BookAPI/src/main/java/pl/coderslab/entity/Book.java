package pl.coderslab.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    @NotBlank
    @Size(min = 5)
    private String title;



    private String author;

    private String publisher;

    private String type;








//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Book)) return false;
//        Book book = (Book) o;
//        return getId().equals(book.getId()) &&
//                getIsbn().equals(book.getIsbn()) &&
//                getTitle().equals(book.getTitle()) &&
//                getAuthor().equals(book.getAuthor()) &&
//                getPublisher().equals(book.getPublisher()) &&
//                getType().equals(book.getType());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getIsbn(), getTitle(), getAuthor(), getPublisher(), getType());
//    }

}
