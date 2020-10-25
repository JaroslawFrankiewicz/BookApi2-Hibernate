package pl.coderslab.entity;

import lombok.*;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
//@AllArgsConstructor
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

    @ISBN
    @NotNull(message = "isbn Is Required")
//    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
//            message = "isbn not Valid")
    @Column(name = "isbn")
    private String isbn;

    @NotBlank
    @Size(min = 5, message = "Title should have at least 5 characters")
    private String title;

    @NotNull
    @Size(min = 2, message = "Author should have at least 2 characters")
    private String author;

    @NotNull
    private String publisher;

    private String type;

}
